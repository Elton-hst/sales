package br.com.microservices.inventory.web.request;

import br.com.microservices.inventory.domain.entity.Order;

public record CreateUpdateEventDto(Order order) {
}
