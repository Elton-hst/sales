package br.com.microservices.service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<Error> authService(AuthException exception, HttpServletRequest request) {
        return response(exception.getMessage(), request, HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }

    private ResponseEntity<Error> response(final String message, final HttpServletRequest request, final HttpStatus status, LocalDateTime data) {
        return ResponseEntity
                .status(status)
                .body(new Error(message, status.value(), data, request.getRequestURI()));
    }

}
