package br.com.microservices.orchestrator.application.exception;

public class ValidatorException extends RuntimeException{
    public ValidatorException(String messagem){
        super(messagem);
    }
}
