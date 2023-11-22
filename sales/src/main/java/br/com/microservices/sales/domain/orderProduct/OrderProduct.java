package br.com.microservices.sales.domain.orderProduct;

import br.com.microservices.sales.domain.product.Product;
import br.com.microservices.sales.infrastructure.persistence.entity.OrderProductEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Builder @Data
@EqualsAndHashCode
public class OrderProduct {

    private UUID id;
    private Product product;
    private int quantity;

}
