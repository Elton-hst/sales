package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.service.ProductService;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.entity.Product;
import br.com.microservices.sales.domain.repository.ProductRepository;
import br.com.microservices.sales.application.exception.ProductException;
import br.com.microservices.sales.domain.validator.CreateUpdateProductsDtoValidator;

import java.util.ArrayList;
import java.util.List;

public class CreateProductUseCase implements ProductService {

    private final ProductRepository repository;
    private final ProductFactory productFactory;
    public CreateProductUseCase(ProductRepository repository, ProductFactory productFactory) {
        this.repository = repository;
        this.productFactory = productFactory;
    }

    public List<CommonProduct> create(List<CommonProduct> products) {
        List<CommonProduct> productList = new ArrayList<>();

        for (CommonProduct product : products) {
            Product create = productFactory.create(product.getCode(), product.getUnitValue());
            Validator.validate(new CreateUpdateProductsDtoValidator(), create);
            productList.add(createProduct(create));
        }

        return productList;
    }

    private CommonProduct createProduct(Product product) {
        var result = CommonProduct.builder()
                .code(product.getCode())
                .unitValue(product.getUnitValue())
                .build();

        return repository.add(result)
                .orElseThrow(() -> new ProductException("erro ao tentar criar um novo produto"));
    }

}
