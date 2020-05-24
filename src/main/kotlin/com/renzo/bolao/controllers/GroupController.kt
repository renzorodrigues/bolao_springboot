package com.renzo.bolao.controllers

import com.renzo.bolao.domains.Group
import com.renzo.bolao.domains.User
import com.renzo.bolao.dto.GroupDTO
import com.renzo.bolao.services.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
class GroupController @Autowired constructor(private val service: GroupService) {

    @GetMapping("/group/{id}")
    fun getGroup(@PathVariable id: Int): ResponseEntity<Group> {
        val obj: Group = service.getGroup(id)
        return ResponseEntity.ok().body(obj)
    }

    @PostMapping("/group/")
    fun insertGroup(@RequestBody obj: Group): ResponseEntity<Void> {
        val obj = service.insertGroup(obj)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @PutMapping("/group/{id}")
    fun updateGroup(@RequestBody obj: Group, @PathVariable id: Int): ResponseEntity<Void> {
        obj.id = id
        val obj = service.updateGroup(obj)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/group/{id}")
    fun deleteGroup(@PathVariable id: Int): ResponseEntity<Void> {
        service.deleteGroup(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/group")
    fun getAllGroup(): ResponseEntity<List<GroupDTO>> {
        val list: List<Group> = service.getAllGroup()
        val listDto: List<GroupDTO> = list.map { obj -> GroupDTO(obj) }
        return ResponseEntity.ok().body(listDto)
    }
}