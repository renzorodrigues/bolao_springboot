package com.renzo.bolao.controllers

import com.renzo.bolao.domain.User
<<<<<<< HEAD
import com.renzo.bolao.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
=======
>>>>>>> fce0dd3a01e6154c77660c01c8d7430fd3725ded
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
<<<<<<< HEAD
class UserController @Autowired constructor(private val service: UserService) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<Any> {
        val obj: User = service.getUser(id)
        return ResponseEntity.ok().body(obj)
=======
class UserController {
    @GetMapping("/hello")
    fun show(): List<User> {
        val user1 = User(12,"renzors@gmail.com","Renzo")
        val user2 = User(23, "maria@uol.com", "Julianna")
        val lista = listOf<User>(user1, user2)
        return lista
>>>>>>> fce0dd3a01e6154c77660c01c8d7430fd3725ded
    }
}