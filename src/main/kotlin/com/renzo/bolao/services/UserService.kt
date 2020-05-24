package com.renzo.bolao.services

import com.renzo.bolao.domains.User
import com.renzo.bolao.repositories.UserRepository
import com.renzo.bolao.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService @Autowired constructor(private val repo: UserRepository) {

    fun getUser(id: Int): User {
        val obj: Optional<User> = repo.findById(id)
        return obj.orElseThrow { ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + User::class.simpleName as String) }
    }

    fun insertUser(obj: User): User {
        obj.id = null
        return repo.save(obj)
    }

    fun updateUser(obj: User): User {
        getUser(obj.id!!)
        return repo.save(obj)
    }

    fun deleteUser(id: Int) {
        getUser(id)
        repo.deleteById(id)
    }

    fun getAllUser(): List<User> {
        return repo.findAll()
    }

    fun getUserPage(page: Int, linesPerPage: Int, direction: String, orderBy: String): Page<User> {
        val pageRequest: PageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy)
        return repo.findAll(pageRequest)
    }
}