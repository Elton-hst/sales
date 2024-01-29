package br.com.microservice.payment.web.response;

import br.com.microservice.payment.domain.entity.Product;
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
