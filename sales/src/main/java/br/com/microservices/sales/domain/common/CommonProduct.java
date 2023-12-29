package br.com.microservices.sales.domain.common;

import br.com.microservices.sales.domain.entity.Product;
import br.com.microservices.sales.persistence.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CommonProduct implements Product {

    private UUID id;
    private String code;
    private double unitValue;

    @Override
    public UUID id() {
        return null;
    }
    @Override
    public String code() {
        return null;
    }
    @Override
    public double unitValue() {
        return 0;
    }

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .id(id())
                .unitValue(unitValue())
                .code(code())
                .build();
    }
}
