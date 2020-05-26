package com.renzo.bolao.domains

import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "tgroup")
data class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        var name: String,
        var limitOfMembers: Int,

        @ManyToOne
        var creatorMember: Member?,

        @ManyToOne
        val pool: Pool?
) {
    @ManyToMany()
    @JoinTable(name = "tgroup_tmember",
            joinColumns = [JoinColumn(name = "group_id")],
            inverseJoinColumns = [JoinColumn(name = "member_id")])
    var members: List<Member> = mutableListOf<Member>()
}