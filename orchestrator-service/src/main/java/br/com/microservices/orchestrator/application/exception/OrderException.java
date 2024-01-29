package br.com.microservices.orchestrator.application.exception;

public class OrderException extends RuntimeException{
    public OrderException(String menssagem) {
        super(menssagem);
    }
}
