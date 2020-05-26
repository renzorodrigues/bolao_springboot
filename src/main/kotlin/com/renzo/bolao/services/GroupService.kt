package com.renzo.bolao.services

import com.renzo.bolao.domains.Group
import com.renzo.bolao.dto.GroupDTO
import com.renzo.bolao.repositories.GroupRepository
import com.renzo.bolao.services.exceptions.ObjectNotFoundException
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class GroupService @Autowired constructor(private val repo: GroupRepository, private val memberServ: MemberService) {

    val modelMapper: ModelMapper = ModelMapper()

    fun getOne(id: Int): Group {
        val obj: Optional<Group> = repo.findById(id)
        return obj.orElseThrow { ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Group::class.simpleName as String) }
    }

    @Transactional
    fun insert(obj: Group): Group {
        obj.id = null
        return repo.save(obj)
    }

    fun update(obj: Group): Group {
        val newObj = getOne(obj.id!!)
        updateData(newObj, obj)
        return repo.save(newObj)
    }

    fun delete(id: Int) {
        getOne(id)
        repo.deleteById(id)
    }

    fun getAll(): List<Group> {
        return repo.findAll()
    }

    fun getPage(page: Int, linesPerPage: Int, direction: String, orderBy: String): Page<Group> {
        val pageRequest: PageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy)
        return repo.findAll(pageRequest)
    }

    fun fromDTO(objDto: GroupDTO): Group {
        return Group(objDto.id, objDto.name, objDto.limitOfMembers, memberServ.toMember(objDto.creatorId), null)
    }

    fun updateData(newObj: Group, obj: Group) {
        newObj.name = obj.name
        newObj.limitOfMembers = obj.limitOfMembers
    }
}