package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.common.CommonProduct;
import br.com.microservices.sales.application.exception.ProductException;
import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.entity.Product;
import br.com.microservices.sales.domain.repository.ProductRepository;
import br.com.microservices.sales.domain.validator.CreateUpdateProductsDtoValidator;

import java.util.HashSet;
import java.util.Set;

public class CreateProductUseCase {

    private final ProductRepository repository;
    private final ProductFactory productFactory;
    public CreateProductUseCase(ProductRepository repository, ProductFactory productFactory) {
        this.repository = repository;
        this.productFactory = productFactory;
    }

    public Set<Product> create(Set<Product> products) {
        Set<Product> productList = new HashSet<>();

        for (Product product : products) {
            Product create = productFactory.create(product.getCode(), product.getUnitValue());
            Validator.validate(new CreateUpdateProductsDtoValidator(), create);
            productList.add(create);
        }

        return productList;
    }

    private CommonProduct createProduct(Product product) {
        var result = CommonProduct.builder()
                .code(product.getCode())
                .unitValue(product.getUnitValue()).build();

        return repository.add(result)
                .orElseThrow(() -> new ProductException("erro ao tentar criar um novo produto"));
    }

}
