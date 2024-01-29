package br.com.microservice.payment.application.exception;

public class EventException extends RuntimeException{
    public EventException(String message) {
        super(message);
    }
}
