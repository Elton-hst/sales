package br.com.microservices.sales.domain.entity;

import br.com.microservices.sales.domain.common.CommonProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface Order {

    UUID id();
    List<CommonProduct> products();
    String transactionId();
    int quantity();
    LocalDateTime createdAt();
    double totalAmount();
    int totalItems();


}
