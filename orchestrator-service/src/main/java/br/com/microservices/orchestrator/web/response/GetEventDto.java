package br.com.microservices.orchestrator.web.response;

import br.com.microservices.orchestrator.domain.entity.Order;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetEventDto(
        Order order,
        String source,
        String status,
        LocalDateTime createdAt) {

}
