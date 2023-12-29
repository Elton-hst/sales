package br.com.microservices.sales.application.exception;

public class OrderException extends RuntimeException{
    public OrderException(String menssagem) {
        super(menssagem);
    }
}
