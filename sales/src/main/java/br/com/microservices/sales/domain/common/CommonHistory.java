package br.com.microservices.sales.domain.common;

import br.com.microservices.sales.domain.entity.History;
import br.com.microservices.sales.persistence.entity.HistoryEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class CommonHistory implements History {

    private String source;
    private String status;
    private String message;
    private LocalDateTime createdAt;

    @Override
    public String source() {
        return source;
    }
    @Override
    public String status() {
        return status;
    }
    @Override
    public String message() {
        return message;
    }
    @Override
    public LocalDateTime createAt() {
        return createdAt;
    }

    public HistoryEntity toEntity() {
        return HistoryEntity.builder()
                .source(source())
                .status(status())
                .message(message())
                .createdAt(createAt())
                .build();
    }

}
