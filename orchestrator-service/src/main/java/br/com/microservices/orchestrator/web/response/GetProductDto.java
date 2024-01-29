package br.com.microservices.orchestrator.web.response;

import br.com.microservices.orchestrator.domain.entity.Product;
import lombok.Builder;

@Builder
public record GetProductDto(
        String code,
        double unitValue) {

    public Product toProduct() {
        return new Product(
                code,
                unitValue
        );
    }

}
