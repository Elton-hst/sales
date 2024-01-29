package br.com.microservice.payment.application.exception;

public class ValidatorException extends RuntimeException{
    public ValidatorException(String messagem){
        super(messagem);
    }
}
