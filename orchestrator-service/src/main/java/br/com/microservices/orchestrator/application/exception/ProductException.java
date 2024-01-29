package br.com.microservices.orchestrator.application.exception;

public class ProductException extends RuntimeException{
    public ProductException(String menssage) {
        super(menssage);
    }
}
