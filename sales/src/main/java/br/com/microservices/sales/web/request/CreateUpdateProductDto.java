package br.com.microservices.sales.web.request;

public record CreateUpdateProductDto(
        String code,
        double unitValue) {

}
