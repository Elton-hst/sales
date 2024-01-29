package br.com.microservice.payment.application.useCases;

import br.com.microservice.payment.domain.configs.factory.ProductFactory;
import br.com.microservice.payment.domain.configs.validation.Validator;
import br.com.microservice.payment.domain.entity.Product;
import br.com.microservice.payment.domain.validator.CreateUpdateProductsDtoValidator;
import br.com.microservice.payment.web.request.CreateUpdateProductDto;
import br.com.microservice.payment.web.response.GetProductDto;

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
