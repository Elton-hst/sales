package br.com.microservices.sales.domain.entity;

import br.com.microservices.sales.application.common.CommonHistory;
import br.com.microservices.sales.application.common.CommonOrder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface Event {

    UUID getId();
    String getTransactionId();
    UUID getOrderId();
    CommonOrder getPayload();
    String getSource();
    String getStatus();
    List<CommonHistory> getEventHistory();
    LocalDateTime getCreatedAt();

}
