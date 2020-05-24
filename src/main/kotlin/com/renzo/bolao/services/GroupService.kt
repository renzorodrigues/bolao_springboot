package com.renzo.bolao.services

import com.renzo.bolao.domains.Group
import com.renzo.bolao.repositories.GroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GroupService @Autowired constructor(private val repo: GroupRepository) {

    fun getGroup(id: Int): Group {
        return repo.getOne(id)
    }
}