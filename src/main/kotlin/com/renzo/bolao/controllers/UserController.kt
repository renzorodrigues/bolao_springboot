package com.renzo.bolao.controllers

import com.renzo.bolao.domains.User
import com.renzo.bolao.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
class UserController @Autowired constructor(private val service: UserService) {

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<User> {
        val obj: User = service.getUser(id)
        return ResponseEntity.ok().body(obj)
    }

    @PostMapping("/user")
    fun insertUser(@RequestBody obj: User): ResponseEntity<Void> {
        val obj = service.insertUser(obj)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @PutMapping("/user/{id}")
    fun updateUser(@RequestBody obj: User, @PathVariable id: Int): ResponseEntity<Void> {
        obj.id = id
        val obj = service.updateUser(obj)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable id: Int): ResponseEntity<Void> {
        service.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/user")
    fun getAllUser(): ResponseEntity<List<User>> {
        val list: List<User> = service.getAllUser()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/user/page")
    fun getUserPage(
            @RequestParam(value = "page", defaultValue = "0") page: Int,
            @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
            @RequestParam(value = "orderBy", defaultValue = "name") orderBy: String,
            @RequestParam(value = "direction", defaultValue = "ASC") direction: String
    ): ResponseEntity<Page<User>> {
        val list: Page<User> = service.getUserPage(page, linesPerPage, direction, orderBy)
        return ResponseEntity.ok().body(list)
    }
}