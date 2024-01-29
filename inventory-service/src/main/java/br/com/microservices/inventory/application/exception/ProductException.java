package br.com.microservices.inventory.application.exception;

public class ProductException extends RuntimeException{
    public ProductException(String menssage) {
        super(menssage);
    }
}
