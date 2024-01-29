package br.com.microservices.orchestrator.application.exception;

public class EventException extends RuntimeException{
    public EventException(String message) {
        super(message);
    }
}
