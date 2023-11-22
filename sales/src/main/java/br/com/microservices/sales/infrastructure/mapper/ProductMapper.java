package br.com.microservices.sales.infrastructure.mapper;

import br.com.microservices.sales.domain.product.Product;
import br.com.microservices.sales.infrastructure.persistence.entity.ProductEntity;

import java.util.UUID;

public class ProductMapper {

    public static ProductEntity toEntity(Product product){
        return ProductEntity.builder()
                .code(product.getCode())
                .unitValue(product.getUnitValue())
                .build();
    }

    public static Product toProduct(ProductEntity product){
        return Product.builder()
                .id(product.getId())
                .code(product.getCode())
                .unitValue(product.getUnitValue())
                .build();
    }

}
