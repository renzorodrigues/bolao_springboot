package com.renzo.bolao.controllers.exceptions

data class StandardError(
        val status: Int,
        val message: String,
        val timeStamp: Long
)