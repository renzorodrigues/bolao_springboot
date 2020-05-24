package com.renzo.bolao.services

import com.renzo.bolao.domain.User
import com.renzo.bolao.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private val repo: UserRepository) {

    fun getUser(id: Long): User {
        return repo.getOne(id)
    }
}