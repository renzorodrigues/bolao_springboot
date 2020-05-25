package com.renzo.bolao.services

import com.renzo.bolao.domains.Group
import com.renzo.bolao.repositories.GroupRepository
import com.renzo.bolao.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class GroupService @Autowired constructor(private val repo: GroupRepository) {

    fun getGroup(id: Int): Group {
        val obj: Optional<Group> = repo.findById(id)
        return obj.orElseThrow { ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Group::class.simpleName as String) }
    }

    fun insertGroup(obj: Group): Group {
        obj.id = null
        return repo.save(obj)
    }

    fun updateGroup(obj: Group): Group {
        getGroup(obj.id!!)
        return repo.save(obj)
    }

    fun deleteGroup(id: Int) {
        getGroup(id)
        repo.deleteById(id)
    }

    fun getAllGroup(): List<Group> {
        return repo.findAll()
    }
}