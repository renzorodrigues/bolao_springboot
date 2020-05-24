package com.renzo.bolao.dto

import com.renzo.bolao.domains.Group

class GroupDTO {
    var id: Int
    var name: String

    constructor(obj: Group) {
        this.id = obj.id!!
        this.name = obj.name
    }
}