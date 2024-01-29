package br.com.microservices.inventory.domain.entity;

import br.com.microservices.inventory.persistence.entity.OrderEntity;
import br.com.microservices.inventory.persistence.entity.ProductEntity;
import br.com.microservices.inventory.web.response.GetOrderDto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record Order(
        UUID id,
        Set<Product> products,
        int quantity,
        LocalDateTime createdAt,
        String transactionId,
        double totalAmount,
        int totalItems) {

    public Order(Set<Product> products) {
        this(null, products, 0, null, null, 0, 0);
    }

    public Order(Set<Product> products, LocalDateTime createdAt, String transactionId) {
        this(null, products, 0, createdAt, transactionId, 0, 0);
    }

    public GetOrderDto toOrderDto() {
        return GetOrderDto.builder()
                .id(id)
                .products(products)
                .quantity(quantity)
                .createdAt(createdAt)
                .transactionId(transactionId)
                .totalAmount(totalAmount)
                .totalItems(totalItems)
                .build();
    }

    public OrderEntity toEntity() {
        return OrderEntity.builder()
                .id(id)
                .products(products.stream()
                        .map(product -> new ProductEntity(product.code(), product.unitValue()))
                        .collect(Collectors.toSet()))
                .quantity(quantity)
                .createdAt(createdAt)
                .totalAmount(totalAmount)
                .totalItems(totalItems)
                .transactionId(transactionId)
                .build();
    }

}
