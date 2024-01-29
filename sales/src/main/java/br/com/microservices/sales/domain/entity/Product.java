package br.com.microservices.sales.domain.entity;

import br.com.microservices.sales.persistence.entity.ProductEntity;

import java.util.UUID;

public record Product(
        UUID id,
        String code,
        double unitValue) {

    public Product(String code, double unitValue) {
        this(null, code, unitValue);
    }

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .code(code)
                .unitValue(unitValue)
                .build();
    }
}
