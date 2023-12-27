package br.com.microservices.sales.domain.common;

import br.com.microservices.sales.domain.entity.Product;
import br.com.microservices.sales.persistence.entity.ProductEntity;
import lombok.Builder;

import java.util.UUID;

@Builder
public class CommonProduct implements Product {

    private UUID id;
    private String code;
    private double unitValue;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .id(id)
                .unitValue(unitValue)
                .code(code)
                .build();
    }

    @Override
    public UUID id() { return id; }
    @Override
    public String code() { return code; }
    @Override
    public double unitValue() { return unitValue; }

}
