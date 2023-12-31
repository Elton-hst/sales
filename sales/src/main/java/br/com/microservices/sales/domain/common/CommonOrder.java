package br.com.microservices.sales.domain.common;

import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.persistence.entity.OrderEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommonOrder implements Order {

    // Campos privados da classe
    private UUID id;
    private List<CommonProduct> products;
    private int quantity;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

    // Construtor privado para impedir a criação direta de instâncias
    private CommonOrder() {
    }
    // Métodos da interface Order
    @Override
    public UUID getId() {
        return id;
    }
    @Override
    public List<CommonProduct> getProducts() {
        return products;
    }
    @Override
    public String getTransactionId() {
        return transactionId;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }
    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    @Override
    public double getTotalAmount() {
        return totalAmount;
    }
    @Override
    public int getTotalItems() {
        return totalItems;
    }

    // Método para converter CommonOrder em OrderEntity
    public OrderEntity toEntity() {
        return OrderEntity.builder()
                .id(getId())
                .products(getProducts()
                        .stream()
                        .map(CommonProduct::toEntity)
                        .collect(Collectors.toList()))
                .quantity(getQuantity())
                .createdAt(getCreatedAt())
                .totalAmount(getTotalAmount())
                .totalItems(getTotalItems())
                .transactionId(getTransactionId())
                .build();
    }

    // Builder estático para facilitar a criação de instâncias de CommonOrder
    public static CommonOrderBuilder builder() {
        return new CommonOrderBuilder();
    }

    // Builder interno estático para construção fluente
    public static final class CommonOrderBuilder {
        private UUID id;
        private List<CommonProduct> products;
        private int quantity;
        private LocalDateTime createdAt;
        private String transactionId;
        private double totalAmount;
        private int totalItems;

        private CommonOrderBuilder() {
        }
        public CommonOrderBuilder id(UUID id) {
            this.id = id;
            return this;
        }
        public CommonOrderBuilder products(List<CommonProduct> products) {
            this.products = products;
            return this;
        }
        public CommonOrderBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        public CommonOrderBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public CommonOrderBuilder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }
        public CommonOrderBuilder totalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
        public CommonOrderBuilder totalItems(int totalItems) {
            this.totalItems = totalItems;
            return this;
        }

        public CommonOrder build() {
            CommonOrder commonOrder = new CommonOrder();
            commonOrder.products = this.products;
            commonOrder.createdAt = this.createdAt;
            commonOrder.totalItems = this.totalItems;
            commonOrder.id = this.id;
            commonOrder.totalAmount = this.totalAmount;
            commonOrder.quantity = this.quantity;
            commonOrder.transactionId = this.transactionId;
            return commonOrder;
        }
    }
}

