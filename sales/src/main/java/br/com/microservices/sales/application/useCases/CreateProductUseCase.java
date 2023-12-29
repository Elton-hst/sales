package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.service.ProductService;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.repository.ProductRepository;
import br.com.microservices.sales.application.exception.ProductException;

import java.util.ArrayList;
import java.util.List;

public class CreateProductUseCase implements ProductService {

    private final ProductRepository repository;
    public CreateProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public List<CommonProduct> create(List<CommonProduct> products) {
        List<CommonProduct> productList = new ArrayList<>();

        for (CommonProduct product : products) {
            var create = CommonProduct.builder()
                    .id(product.id())
                    .code(product.code())
                    .unitValue(product.unitValue())
                    .build();

            productList.add(createProduct(create));
        }

        return productList;
    }

    private CommonProduct createProduct(CommonProduct product) {
        return repository.add(product)
                .orElseThrow(() -> new ProductException("erro ao tentar criar um novo produto"));
    }

}
