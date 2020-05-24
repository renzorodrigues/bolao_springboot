package com.renzo.bolao.domains

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "tuser")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        val name: String,
        val email: String
) {
    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    var groups: List<Group> = mutableListOf<Group>()
}