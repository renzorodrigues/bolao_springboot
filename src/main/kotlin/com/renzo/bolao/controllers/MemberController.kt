package com.renzo.bolao.controllers

import com.renzo.bolao.domains.Member
import com.renzo.bolao.services.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
class MemberController @Autowired constructor(private val serv: MemberService) {

    @GetMapping("/member/{id}")
    fun getOne(@PathVariable id: Int): ResponseEntity<Member> {
        val obj: Member = serv.getOne(id)
        return ResponseEntity.ok().body(obj)
    }

    @PostMapping("/member")
    fun insert(@RequestBody obj: Member): ResponseEntity<Void> {
        val obj = serv.insert(obj)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @PutMapping("/member/{id}")
    fun update(@RequestBody obj: Member, @PathVariable id: Int): ResponseEntity<Void> {
        obj.id = id
        val obj = serv.update(obj)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/member/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        serv.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/member")
    fun getAll(): ResponseEntity<List<Member>> {
        val list: List<Member> = serv.getAll()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/member/page")
    fun getPage(
            @RequestParam(value = "page", defaultValue = "0") page: Int,
            @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
            @RequestParam(value = "orderBy", defaultValue = "name") orderBy: String,
            @RequestParam(value = "direction", defaultValue = "ASC") direction: String
    ): ResponseEntity<Page<Member>> {
        val list: Page<Member> = serv.getPage(page, linesPerPage, direction, orderBy)
        return ResponseEntity.ok().body(list)
    }
}