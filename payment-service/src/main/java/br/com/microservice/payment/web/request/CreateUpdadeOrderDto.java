package br.com.microservice.payment.web.request;

import br.com.microservice.payment.domain.entity.Product;

import java.util.Set;

public record CreateUpdadeOrderDto(
        Set<Product> products) {


}
