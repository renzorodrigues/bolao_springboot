package com.renzo.bolao.dto

import com.renzo.bolao.domains.Group

data class GroupDTO(
        var id: Int?,
        var name: String,
        var creatorId: Int?,
        var limitOfMembers: Int,
        var numberOfMembers: Int,
        var poolId: Int?
) {
    constructor(obj: Group) : this(
            obj.id,
            obj.name,
            obj.creatorMember.id,
            obj.limitOfMembers,
            obj.members.size,
            obj.pool.id
    )
}