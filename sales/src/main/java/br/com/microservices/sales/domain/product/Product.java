package br.com.microservices.sales.domain.product;

import br.com.microservices.sales.infrastructure.persistence.entity.ProductEntity;
import lombok.*;

@Builder @Data
@EqualsAndHashCode
public class Product {

    private String id;
    private String code;
    private double unitValue;

}
