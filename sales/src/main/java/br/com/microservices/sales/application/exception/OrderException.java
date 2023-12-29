package br.com.microservices.sales.infrastructure.exception;

public class OrderException extends RuntimeException{
    public OrderException(String menssagem) {
        super(menssagem);
    }
}
