package br.com.microservices.sales.domain.entity;

import br.com.microservices.sales.domain.common.CommonProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface Order {

    UUID getId();
    List<CommonProduct> getProducts();
    String getTransactionId();
    int getQuantity();
    LocalDateTime getCreatedAt();
    double getTotalAmount();
    int getTotalItems();


}
