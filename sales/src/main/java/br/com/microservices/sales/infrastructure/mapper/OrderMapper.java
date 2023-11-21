package br.com.microservices.sales.infrastructure.mapper;

import br.com.microservices.sales.domain.order.Order;
import br.com.microservices.sales.domain.order.dto.GetOrderDto;
import br.com.microservices.sales.infrastructure.persistence.entity.OrderEntity;

public class OrderMapper {

    public static OrderEntity toEntity(Order order){
        return OrderEntity.builder()
                .id(order.getId())
                .products(order.getProducts().stream()
                        .map(OrderProductMapper::toEntity)
                        .toList())
                .createdAt(order.getCreatedAt())
                .totalAmount(order.getTotalAmount())
                .totalItems(order.getTotalItems())
                .transactionId(order.getTransactionId())
                .build();
    }

    public static GetOrderDto getOrderDto(Order order){
        return GetOrderDto.builder()
                .products(order.getProducts())
                .createdAt(order.getCreatedAt())
                .totalAmount(order.getTotalAmount())
                .totalItems(order.getTotalItems())
                .transactionId(order.getTransactionId())
                .build();
    }

    public static Order toOrder(OrderEntity order) {
        return Order.builder()
                .id(order.getId())
                .products(order.getProducts().stream()
                        .map(OrderProductMapper::toOrderProduct)
                        .toList())
                .createdAt(order.getCreatedAt())
                .totalAmount(order.getTotalAmount())
                .totalItems(order.getTotalItems())
                .transactionId(order.getTransactionId())
                .build();
    }

}
