package br.com.microservices.sales.infrastructure.exception;

public class ProductException extends RuntimeException{
    public ProductException(String menssage) {
        super(menssage);
    }
}
