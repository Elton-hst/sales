package br.com.microservices.sales.web.response;

import br.com.microservices.sales.domain.entity.Order;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetEventDto(
        Order order,
        String source,
        String status,
        LocalDateTime createdAt) {

}
