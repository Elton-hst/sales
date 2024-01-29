package br.com.microservice.payment.application.exception;

public class ProductException extends RuntimeException{
    public ProductException(String menssage) {
        super(menssage);
    }
}
