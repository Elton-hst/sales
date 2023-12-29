package br.com.microservices.sales.application.exception;

public class ValidatorException extends RuntimeException{
    public ValidatorException(String messagem){
        super(messagem);
    }
}
