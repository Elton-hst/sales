package br.com.microservice.payment.application.exception;

public class OrderException extends RuntimeException{
    public OrderException(String menssagem) {
        super(menssagem);
    }
}
