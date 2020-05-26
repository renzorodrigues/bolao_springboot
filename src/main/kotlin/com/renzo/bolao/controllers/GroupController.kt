package com.renzo.bolao.controllers

import com.renzo.bolao.domains.Group
import com.renzo.bolao.dto.GroupDTO
import com.renzo.bolao.services.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
class GroupController @Autowired constructor(private val serv: GroupService) {

    @GetMapping("/group/{id}")
    fun getOne(@PathVariable id: Int): ResponseEntity<Group> {
        val obj: Group = serv.getOne(id)
        return ResponseEntity.ok().body(obj)
    }

    @PostMapping("/group/")
    fun insert(@RequestBody objDto: GroupDTO): ResponseEntity<Void> {
        val obj: Group = serv.fromDTO(objDto)
        val objSaved = serv.insert(obj)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objSaved.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @PutMapping("/group/{id}")
    fun update(@Valid @RequestBody objDto: GroupDTO, @PathVariable id: Int): ResponseEntity<Void> {
        val obj: Group = serv.fromDTO(objDto)
        obj.id = id
        serv.update(obj)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/group/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        serv.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/group")
    fun getAll(): ResponseEntity<List<GroupDTO>> {
        val list: List<Group> = serv.getAll()
        val listDto: List<GroupDTO> = list.map { obj -> GroupDTO(obj) }
        return ResponseEntity.ok().body(listDto)
    }
}