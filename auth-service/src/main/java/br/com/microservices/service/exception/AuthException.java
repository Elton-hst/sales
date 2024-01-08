package br.com.microservices.service.exception;

public class AuthException extends RuntimeException{

    public AuthException(String msn) {
        super(msn);
    }

}
