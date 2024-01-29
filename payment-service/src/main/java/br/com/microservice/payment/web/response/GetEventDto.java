package br.com.microservice.payment.web.response;

import br.com.microservice.payment.domain.entity.Order;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetEventDto(
        Order order,
        String source,
        String status,
        LocalDateTime createdAt) {

}
