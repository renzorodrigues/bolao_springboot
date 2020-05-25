package com.renzo.bolao.services

import com.renzo.bolao.domains.Member
import com.renzo.bolao.repositories.MemberRepository
import com.renzo.bolao.services.exceptions.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemberService @Autowired constructor(private val repo: MemberRepository) {

    fun getOne(id: Int): Member {
        val obj: Optional<Member> = repo.findById(id)
        return obj.orElseThrow { ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Member::class.simpleName as String) }
    }

    fun insert(obj: Member): Member {
        obj.id = null
        return repo.save(obj)
    }

    fun update(obj: Member): Member {
        getOne(obj.id!!)
        return repo.save(obj)
    }

    fun delete(id: Int) {
        getOne(id)
        repo.deleteById(id)
    }

    fun getAll(): List<Member> {
        return repo.findAll()
    }

    fun getPage(page: Int, linesPerPage: Int, direction: String, orderBy: String): Page<Member> {
        val pageRequest: PageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy)
        return repo.findAll(pageRequest)
    }
}