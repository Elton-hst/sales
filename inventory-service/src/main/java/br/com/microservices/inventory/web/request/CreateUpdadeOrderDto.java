package br.com.microservices.inventory.web.request;

import br.com.microservices.inventory.domain.entity.Product;

import java.util.Set;

public record CreateUpdadeOrderDto(
        Set<Product> products) {


}
