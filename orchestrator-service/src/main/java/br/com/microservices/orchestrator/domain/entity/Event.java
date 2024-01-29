package br.com.microservices.orchestrator.domain.entity;

import br.com.microservices.orchestrator.persistence.entity.EventEntity;
import br.com.microservices.orchestrator.web.response.GetEventDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record Event(
        UUID id,
        Order payload,
        String source,
        String status,
        LocalDateTime createdAt) {

    public Event(Order payload, String source, String status, LocalDateTime createdAt) {
        this(null, payload, source, status, createdAt);
    }

    public GetEventDto toEventDto() {
        return GetEventDto.builder()
                .order(payload)
                .status(status)
                .source(source)
                .createdAt(createdAt)
                .build();
    }

    public EventEntity toEntity() {
        return EventEntity.builder()
                .id(id)
                .payload(payload.toEntity())
                .status(status)
                .source(source)
                .createdAt(createdAt)
                .build();
    }

}
