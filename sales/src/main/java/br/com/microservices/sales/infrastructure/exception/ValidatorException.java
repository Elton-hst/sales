package br.com.microservices.sales.infrastructure.exception;

public class ValidatorException extends RuntimeException{
    public ValidatorException(String messagem){
        super(messagem);
    }
}
