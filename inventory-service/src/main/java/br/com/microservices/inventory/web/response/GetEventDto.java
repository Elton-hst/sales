package br.com.microservices.inventory.web.response;

import br.com.microservices.inventory.domain.entity.Order;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetEventDto(
        Order order,
        String source,
        String status,
        LocalDateTime createdAt) {

}
