package br.com.microservices.sales.web.request;

import java.util.UUID;

public record CreateUpdateProductDto(
        UUID id,
        String code,
        double unitValue) {
}
