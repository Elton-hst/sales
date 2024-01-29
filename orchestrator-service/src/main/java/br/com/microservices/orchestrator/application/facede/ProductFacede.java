package br.com.microservices.orchestrator.application.facede;

import br.com.microservices.orchestrator.application.useCases.CreateProductUseCase;
import br.com.microservices.orchestrator.web.request.CreateUpdateProductDto;
import br.com.microservices.orchestrator.web.response.GetProductDto;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductFacede {

    private final CreateProductUseCase createProductUseCase;

    public ProductFacede(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    public Set<GetProductDto> createProduct(Set<CreateUpdateProductDto> products) {
        return createProductUseCase.create(products);
    }
}
