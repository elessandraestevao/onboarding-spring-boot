package br.com.onboardingspring.controllers.advice

import jdk.net.SocketFlow
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.ResponseStatusException

@ControllerAdvice
class ControllerAdvice{
    @ExceptionHandler(ResponseStatusException::class)
        fun handleResponseStatusException(e: ResponseStatusException): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("I DIDN'T FIND YOUR BOOK: ${e.reason}")
    }
}
