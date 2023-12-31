package br.com.microservices.sales.domain.entity;

import br.com.microservices.sales.domain.common.CommonHistory;
import br.com.microservices.sales.domain.common.CommonOrder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface Event {

    UUID id();
    String transactionId();
    UUID orderId();
    CommonOrder payload();
    String source();
    String status();
    List<CommonHistory> eventHistory();
    LocalDateTime createdAt();

}
