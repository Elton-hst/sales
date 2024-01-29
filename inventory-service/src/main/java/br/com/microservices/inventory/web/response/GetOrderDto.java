package br.com.microservices.inventory.web.response;

import br.com.microservices.inventory.domain.entity.Order;
import br.com.microservices.inventory.domain.entity.Product;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
public record GetOrderDto(
        UUID id,
        Set<Product> products,
        int quantity,
        LocalDateTime createdAt,
        String transactionId,
        double totalAmount,
        int totalItems) {

    public Order toOrder() {
        return new Order(
                id,
                products,
                quantity,
                createdAt,
                transactionId,
                totalAmount,
                totalItems
        );
    }

}
