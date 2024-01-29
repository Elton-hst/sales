package br.com.microservices.orchestrator.web.request;

import br.com.microservices.orchestrator.domain.entity.Product;

import java.util.Set;

public record CreateUpdadeOrderDto(
        Set<Product> products) {


}
