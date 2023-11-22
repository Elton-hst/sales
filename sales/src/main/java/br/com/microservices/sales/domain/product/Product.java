package br.com.microservices.sales.domain.product;

import br.com.microservices.sales.infrastructure.persistence.entity.ProductEntity;
import lombok.*;

import java.util.UUID;

@Builder @Data
@EqualsAndHashCode
public class Product {

    private UUID id;
    private String code;
    private double unitValue;

}
