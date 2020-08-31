package com.neto.desafio.advice

import com.neto.desafio.exception.PlanetaNotFoundException
import com.neto.desafio.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(PlanetaNotFoundException::class)
    fun planetaNotFoundException(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception): ResponseEntity<ErrorMessage> {
        return ResponseEntity(
                ErrorMessage(Date(),
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.name,
                        exception.message
                                ?: "Not Found"
                ), HttpStatus.BAD_REQUEST)


    }
}