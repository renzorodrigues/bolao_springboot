package com.renzo.bolao.services

import com.renzo.bolao.domains.User
import com.renzo.bolao.repositories.UserRepository
import com.renzo.bolao.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.reflect.typeOf

@Service
class UserService @Autowired constructor(private val repo: UserRepository) {

    fun getUser(id: Int): User {
        var obj: Optional<User> = repo.findById(id)
        return obj.orElseThrow { ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + User::class.simpleName as String) }
    }
}