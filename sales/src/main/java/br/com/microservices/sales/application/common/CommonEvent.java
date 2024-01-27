package br.com.microservices.sales.application.common;

import br.com.microservices.sales.domain.entity.Event;
import br.com.microservices.sales.persistence.entity.EventEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CommonEvent implements Event {

    private UUID id;
    private String transactionId;
    private UUID orderId;
    private CommonOrder payload;
    private String source;
    private String status;
    private List<CommonHistory> eventHistory;
    private LocalDateTime createdAt;

    private CommonEvent() {
    }
    @Override
    public UUID getId() {
        return id;
    }
    @Override
    public String getTransactionId() {
        return transactionId;
    }
    @Override
    public UUID getOrderId() {
        return orderId;
    }
    @Override
    public CommonOrder getPayload() {
        return payload;
    }
    @Override
    public String getSource() {
        return source;
    }
    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public List<CommonHistory> getEventHistory() {
        return eventHistory;
    }
    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public EventEntity toEntity() {
        return EventEntity.builder()
                .id(getId())
                .build();
    }

    public static CommonEventBuilder builder() {
        return new CommonEventBuilder();
    }

    public static final class CommonEventBuilder {
        private UUID id;
        private String transactionId;
        private UUID orderId;
        private CommonOrder payload;
        private String source;
        private String status;
        private List<CommonHistory> eventHistory;
        private LocalDateTime createdAt;

        private CommonEventBuilder() {
        }
        public CommonEventBuilder id(UUID id) {
            this.id = id;
            return this;
        }
        public CommonEventBuilder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }
        public CommonEventBuilder orderId(UUID orderId) {
            this.orderId = orderId;
            return this;
        }
        public CommonEventBuilder payload(CommonOrder payload) {
            this.payload = payload;
            return this;
        }
        public CommonEventBuilder source(String source) {
            this.source = source;
            return this;
        }
        public CommonEventBuilder status(String status) {
            this.status = status;
            return this;
        }
        public CommonEventBuilder eventHistory(List<CommonHistory> eventHistory) {
            this.eventHistory = eventHistory;
            return this;
        }
        public CommonEventBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CommonEvent build() {
            CommonEvent commonEvent = new CommonEvent();
            commonEvent.id = this.id;
            commonEvent.transactionId = this.transactionId;
            commonEvent.orderId = this.orderId;
            commonEvent.payload = this.payload;
            commonEvent.source = this.source;
            commonEvent.status = this.status;
            commonEvent.eventHistory = this.eventHistory;
            commonEvent.createdAt = this.createdAt;
            return commonEvent;
        }
    }
}

