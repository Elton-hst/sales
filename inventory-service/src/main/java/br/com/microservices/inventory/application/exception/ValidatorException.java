package br.com.microservices.inventory.application.exception;

public class ValidatorException extends RuntimeException{
    public ValidatorException(String messagem){
        super(messagem);
    }
}
