package br.com.microservices.sales.domain.common;

import br.com.microservices.sales.domain.entity.History;
import br.com.microservices.sales.persistence.entity.HistoryEntity;
import lombok.Builder;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class CommonHistory implements History {

    private String source;
    private String status;
    private String message;
    private LocalDateTime createdAt;

    private CommonHistory() {
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
    public String getMessage() {
        return message;
    }
    @Override
    public LocalDateTime getCreateAt() {
        return createdAt;
    }

    public HistoryEntity toEntity() {
        return HistoryEntity.builder()
                .source(getSource())
                .status(getStatus())
                .message(getMessage())
                .createdAt(getCreateAt())
                .build();
    }

    public static CommonHistoryBuilder builder() {
        return new CommonHistoryBuilder();
    }

    public static final class CommonHistoryBuilder {
        private String source;
        private String status;
        private String message;
        private LocalDateTime createdAt;

        private CommonHistoryBuilder() {
        }
        public CommonHistoryBuilder source(String source) {
            this.source = source;
            return this;
        }
        public CommonHistoryBuilder status(String status) {
            this.status = status;
            return this;
        }
        public CommonHistoryBuilder message(String message) {
            this.message = message;
            return this;
        }
        public CommonHistoryBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CommonHistory build() {
            CommonHistory commonHistory = new CommonHistory();
            commonHistory.source = this.source;
            commonHistory.status = this.status;
            commonHistory.message = this.message;
            commonHistory.createdAt = this.createdAt;
            return commonHistory;
        }
    }
}

