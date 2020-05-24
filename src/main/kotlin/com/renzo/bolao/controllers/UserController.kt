package com.renzo.bolao.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController{
    @GetMapping("/hello")
    fun show() = "hello"
}