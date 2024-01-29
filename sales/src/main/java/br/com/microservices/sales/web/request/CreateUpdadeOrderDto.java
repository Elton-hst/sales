package br.com.microservices.sales.web.request;

import br.com.microservices.sales.domain.entity.Product;

import java.util.Set;

public record CreateUpdadeOrderDto(
        Set<Product> products) {


}
