package br.com.microservices.orchestrator.application.useCases;

import br.com.microservices.orchestrator.domain.configs.factory.ProductFactory;
import br.com.microservices.orchestrator.domain.configs.validation.Validator;
import br.com.microservices.orchestrator.domain.entity.Product;
import br.com.microservices.orchestrator.domain.validator.CreateUpdateProductsDtoValidator;
import br.com.microservices.orchestrator.web.request.CreateUpdateProductDto;
import br.com.microservices.orchestrator.web.response.GetProductDto;

import java.util.HashSet;
import java.util.Set;

public class CreateProductUseCase {

    private final ProductFactory productFactory;
    public CreateProductUseCase(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public Set<GetProductDto> create(Set<CreateUpdateProductDto> products) {
        Set<GetProductDto> productList = new HashSet<>();

        for (CreateUpdateProductDto product : products) {
            Product create = productFactory.create(product.code(), product.unitValue());
            Validator.validate(new CreateUpdateProductsDtoValidator(), create);
            productList.add(new GetProductDto(create.code(), create.unitValue()));
        }

        return productList;
    }

}
