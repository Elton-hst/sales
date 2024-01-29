package br.com.microservices.sales.web.request;

import br.com.microservices.sales.domain.entity.Order;

public record CreateUpdateEventDto(Order order) {
}
