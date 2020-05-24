package com.renzo.bolao.controllers

import com.renzo.bolao.domains.Group
import com.renzo.bolao.services.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GroupController @Autowired constructor(private val service: GroupService) {

    @GetMapping("/group/{id}")
    fun getGroup(@PathVariable id: Int): ResponseEntity<Any> {
        val obj: Group = service.getGroup(id)
        return ResponseEntity.ok().body(obj)
    }
}