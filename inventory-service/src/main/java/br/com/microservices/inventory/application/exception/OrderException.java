package br.com.microservices.inventory.application.exception;

public class OrderException extends RuntimeException{
    public OrderException(String menssagem) {
        super(menssagem);
    }
}
