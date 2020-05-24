package com.renzo.bolao.controllers

import com.renzo.bolao.domains.User
import com.renzo.bolao.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController @Autowired constructor(private val service: UserService) {

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<Any> {
        val obj: User = service.getUser(id)
        return ResponseEntity.ok().body(obj)
    }
}