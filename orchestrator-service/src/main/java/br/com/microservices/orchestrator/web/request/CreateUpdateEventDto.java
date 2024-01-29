package br.com.microservices.orchestrator.web.request;

import br.com.microservices.orchestrator.domain.entity.Order;

public record CreateUpdateEventDto(Order order) {
}
