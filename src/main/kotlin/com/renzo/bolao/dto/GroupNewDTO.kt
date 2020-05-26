package com.renzo.bolao.dto

import com.renzo.bolao.domains.Group
import javax.validation.constraints.NotEmpty

data class GroupNewDTO(
        val id: Int?,
        @field:NotEmpty(message = "Preenchimento obrigatório")
        val name: String,
        val limitOfMembers: Int,
        val creatorId: Int?,
        val poolId: Int?
) {
    constructor(obj: Group) : this(
            obj.id,
            obj.name,
            obj.limitOfMembers,
            obj.creatorMember?.id,
            obj.pool?.id
    )
}