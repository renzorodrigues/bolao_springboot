package com.renzo.bolao.domains

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "tgroup")
data class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        val name: String
) {
    @ManyToMany()
    @JoinTable(name = "tgroup_tuser",
            joinColumns = [JoinColumn(name = "group_id")],
            inverseJoinColumns = [JoinColumn(name = "user_id")])
    var users: List<User> = mutableListOf<User>()
}