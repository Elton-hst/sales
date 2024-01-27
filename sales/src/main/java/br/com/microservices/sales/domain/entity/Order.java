package br.com.microservices.sales.domain.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public interface Order {

    UUID getId();
    Set<Product> getProducts();
    String getTransactionId();
    int getQuantity();
    LocalDateTime getCreatedAt();
    double getTotalAmount();
    int getTotalItems();


}
