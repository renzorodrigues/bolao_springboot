package com.renzo.bolao.dto

import com.renzo.bolao.domains.Group

class GroupDTO {
    var id: Int
    var name: String
    var creator: String
    var limitOfMembers: String
    var numberOfMembers: String

    constructor(obj: Group) {
        this.id = obj.id!!
        this.name = obj.name
        this.creator = obj.creatorMember.name
        this.limitOfMembers = obj.limitOfMembers.toString()
        this.numberOfMembers = obj.members.size.toString()
    }
}