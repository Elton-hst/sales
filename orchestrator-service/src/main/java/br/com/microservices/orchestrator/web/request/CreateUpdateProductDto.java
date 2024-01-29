package br.com.microservices.orchestrator.web.request;

public record CreateUpdateProductDto(
        String code,
        double unitValue) {

}
