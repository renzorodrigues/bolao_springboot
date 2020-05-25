package com.renzo.bolao.domains

import javax.persistence.*

@Entity
@Table(name = "tgroup")
data class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        val name: String,
        val limitOfMembers: Int,

        @ManyToOne
        val creatorMember: Member,

        @ManyToOne
        val pool: Pool
) {
    @ManyToMany()
    @JoinTable(name = "tgroup_tmember",
            joinColumns = [JoinColumn(name = "group_id")],
            inverseJoinColumns = [JoinColumn(name = "member_id")])
    var members: List<Member> = mutableListOf<Member>()
}