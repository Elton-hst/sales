package br.com.microservices.sales.domain.entity;

import java.util.UUID;

public interface Product {

    UUID getId();
    String getCode();
    double getUnitValue();

}
