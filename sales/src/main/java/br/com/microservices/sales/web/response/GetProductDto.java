package br.com.microservices.sales.web.response;

import br.com.microservices.sales.domain.entity.Product;
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
