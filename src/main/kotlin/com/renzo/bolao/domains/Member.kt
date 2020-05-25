package com.renzo.bolao.domains

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "tmember")
data class Member(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        val name: String,
        val email: String
) {
    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    var groups: List<Group> = mutableListOf<Group>()
}