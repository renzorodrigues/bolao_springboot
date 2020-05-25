package com.renzo.bolao.services

import com.renzo.bolao.domains.Group
import com.renzo.bolao.repositories.GroupRepository
import com.renzo.bolao.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class GroupService @Autowired constructor(private val repo: GroupRepository) {

    fun getOne(id: Int): Group {
        val obj: Optional<Group> = repo.findById(id)
        return obj.orElseThrow { ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Group::class.simpleName as String) }
    }

    fun insert(obj: Group): Group {
        obj.id = null
        return repo.save(obj)
    }

    fun update(obj: Group): Group {
        getOne(obj.id!!)
        return repo.save(obj)
    }

    fun delete(id: Int) {
        getOne(id)
        repo.deleteById(id)
    }

    fun getAll(): List<Group> {
        return repo.findAll()
    }
}