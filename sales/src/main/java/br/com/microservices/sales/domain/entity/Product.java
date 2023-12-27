package br.com.microservices.sales.domain.entity;

import java.util.UUID;

public interface Product {

    UUID id();
    String code();
    double unitValue();

}
