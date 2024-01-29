package br.com.microservice.payment.web.request;

public record CreateUpdateProductDto(
        String code,
        double unitValue) {

}
