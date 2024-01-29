package br.com.microservices.inventory.application.exception;

public class EventException extends RuntimeException{
    public EventException(String message) {
        super(message);
    }
}
