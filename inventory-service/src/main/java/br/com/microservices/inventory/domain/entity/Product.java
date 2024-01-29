package br.com.microservices.inventory.domain.entity;

import br.com.microservices.inventory.persistence.entity.ProductEntity;

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
