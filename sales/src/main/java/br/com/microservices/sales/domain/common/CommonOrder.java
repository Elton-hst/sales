package br.com.microservices.sales.domain.common;

import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.persistence.entity.OrderEntity;
import br.com.microservices.sales.web.response.GetOrderDto;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
public class CommonOrder implements Order {

    private UUID id;
    private List<CommonProduct> products;
    private int quantity;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

    @Override
    public UUID getid() {
        return id;
    }
    @Override
    public List<CommonProduct> products() {
        return products;
    }
    @Override
    public String transactionId() {
        return transactionId;
    }
    @Override
    public int quantity() {
        return quantity;
    }
    @Override
    public LocalDateTime createdAt() {
        return createdAt;
    }
    @Override
    public double totalAmount() {
        return totalAmount;
    }
    @Override
    public int totalItems() {
        return totalItems;
    }

    public GetOrderDto getOrderDto(){
        return GetOrderDto.builder()
                .id(getid())
                .products(products())
                .quantity(quantity())
                .createdAt(createdAt())
                .totalAmount(totalAmount())
                .totalItems(totalItems())
                .transactionId(transactionId())
                .build();
    }

    public OrderEntity toEntity() {
        return OrderEntity.builder()
                .id(getid())
                .products(products()
                        .stream()
                        .map(CommonProduct::toEntity)
                        .collect(Collectors.toList()))
                .quantity(quantity())
                .createdAt(createdAt())
                .totalAmount(totalAmount())
                .totalItems(totalItems())
                .transactionId(transactionId())
                .build();
    }
}
