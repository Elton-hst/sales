package br.com.microservices.inventory.web.request;

public record CreateUpdateProductDto(
        String code,
        double unitValue) {

}
