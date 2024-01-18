package br.com.microservices.service.exception;

public class EventException extends RuntimeException{
    public EventException(String menssage) {
        super(menssage);
    }
}
