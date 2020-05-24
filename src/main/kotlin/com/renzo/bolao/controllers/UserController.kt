package com.renzo.bolao.controllers

import com.renzo.bolao.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @GetMapping("/hello")
    fun show(): List<User> {
        val user1 = User(12,"renzors@gmail.com","Renzo")
        val user2 = User(23, "maria@uol.com", "Julianna")
        val lista = listOf<User>(user1, user2)
        return lista
    }
}