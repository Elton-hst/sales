package br.com.microservices.sales.application.exception;

public class EventException extends RuntimeException{
    public EventException(String message) {
        super(message);
    }
}
