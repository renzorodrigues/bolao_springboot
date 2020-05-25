package com.renzo.bolao.domains

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tpool")
data class Pool(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        val lotteryName: String,
        val contestDate: LocalDate
)