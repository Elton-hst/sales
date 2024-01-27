package br.com.microservices.sales.application.facede;

import br.com.microservices.sales.application.useCases.CreateProductUseCase;
import br.com.microservices.sales.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductFacede {

    private final CreateProductUseCase createProductUseCase;

    public ProductFacede(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    public Set<Product> createProduct(Set<Product> products) {
        return createProductUseCase.create(products);
    }
}
