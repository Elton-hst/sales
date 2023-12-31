package br.com.microservices.sales.domain.common;

import br.com.microservices.sales.domain.entity.Event;
import br.com.microservices.sales.persistence.entity.EventEntity;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public class CommonEvent implements Event {

    private UUID id;
    private String transactionId;
    private UUID orderId;
    private CommonOrder payload;
    private String source;
    private String status;
    private List<CommonHistory> eventHistory;
    private LocalDateTime createdAt;

    @Override
    public UUID id() {
        return id;
    }
    @Override
    public String transactionId() {
        return transactionId;
    }
    @Override
    public UUID orderId() {
        return orderId;
    }
    @Override
    public CommonOrder payload() {
        return payload;
    }
    @Override
    public String source() {
        return source;
    }
    @Override
    public String status() {
        return status;
    }
    @Override
    public List<CommonHistory> eventHistory() {
        return eventHistory;
    }
    @Override
    public LocalDateTime createdAt() {
        return createdAt;
    }

    public EventEntity toEntity() {
        return EventEntity.builder()
                .id(id())
                .build();
    }

}
