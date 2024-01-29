package br.com.microservice.payment.web.request;

import br.com.microservice.payment.domain.entity.Order;

public record CreateUpdateEventDto(Order order) {
}
