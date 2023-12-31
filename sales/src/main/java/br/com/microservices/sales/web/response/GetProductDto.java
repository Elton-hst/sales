package br.com.microservices.sales.web.response;

import java.util.UUID;

public record GetProductDto(
        UUID id,
        String code,
        double unitValue) {
}
