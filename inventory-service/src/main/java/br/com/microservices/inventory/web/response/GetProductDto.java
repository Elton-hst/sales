package br.com.microservices.inventory.web.response;

import br.com.microservices.inventory.domain.entity.Product;
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
