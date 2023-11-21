package br.com.microservices.sales.infrastructure.mapper;

import br.com.microservices.sales.domain.orderProduct.OrderProduct;
import br.com.microservices.sales.infrastructure.persistence.entity.OrderProductEntity;

public class OrderProductMapper {

    public static OrderProduct toOrderProduct(OrderProductEntity orderProduct){
        return OrderProduct.builder()
                .id(orderProduct.getId())
                .product(ProductMapper.toProduct(orderProduct.getProduct()))
                .quantity(orderProduct.getQuantity())
                .build();
    }

    public static OrderProductEntity toEntity(OrderProduct orderProduct){
        return OrderProductEntity.builder()
                .id(orderProduct.getId())
                .product(ProductMapper.toEntity(orderProduct.getProduct()))
                .quantity(orderProduct.getQuantity())
                .build();
    }

}
