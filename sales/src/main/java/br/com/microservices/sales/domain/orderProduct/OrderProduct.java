package br.com.microservices.sales.domain.orderProduct;

import br.com.microservices.sales.domain.product.Product;
import br.com.microservices.sales.infrastructure.persistence.entity.OrderProductEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder @Data
@EqualsAndHashCode
public class OrderProduct {

    private String id;
    private Product product;
    private int quantity;

}
