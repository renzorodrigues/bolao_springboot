package com.renzo.bolao.controllers.exceptions

import com.renzo.bolao.services.exceptions.ObjectNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException::class)
    fun objectNotFound(e: ObjectNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val err: StandardError = StandardError(HttpStatus.NOT_FOUND.value(), e.message.toString(), System.currentTimeMillis())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err)
    }
}