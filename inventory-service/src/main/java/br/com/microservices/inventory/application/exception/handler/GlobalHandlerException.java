package br.com.microservices.inventory.application.exception.handler;

import br.com.microservices.inventory.application.exception.OrderException;
import br.com.microservices.inventory.application.exception.ProductException;
import br.com.microservices.inventory.application.exception.ValidatorException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> handlerOrderException(OrderException exception, HttpServletRequest request){
        return response(exception.getMessage(), request, HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handlerProductException(ProductException exception, HttpServletRequest request){
        return response(exception.getMessage(), request, HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
    @ExceptionHandler(ValidatorException.class)
    public ResponseEntity<ErrorResponse> handlerValidatorException(ValidatorException exception, HttpServletRequest request){
        return response(exception.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
    }

    private ResponseEntity<ErrorResponse> response(final String message, final HttpServletRequest request, final HttpStatus status, LocalDateTime data) {
        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(message, data, status.value(), request.getRequestURI()));
    }

}
