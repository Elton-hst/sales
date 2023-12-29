package br.com.microservices.sales.application.exception;

public class ProductException extends RuntimeException{
    public ProductException(String menssage) {
        super(menssage);
    }
}
