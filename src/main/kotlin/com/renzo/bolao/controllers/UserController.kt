package com.renzo.bolao.controllers

import com.renzo.bolao.domains.User
import com.renzo.bolao.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
class UserController @Autowired constructor(private val service: UserService) {

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<Any> {
        val obj: User = service.getUser(id)
        return ResponseEntity.ok().body(obj)
    }

    @PostMapping("/user/")
    fun insertUser(@RequestBody obj: User): ResponseEntity<Void> {
        val obj = service.insertUser(obj)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri()
        return ResponseEntity.created(uri).build()
    }
}