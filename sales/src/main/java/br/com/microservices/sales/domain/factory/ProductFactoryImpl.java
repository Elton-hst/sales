package br.com.microservices.sales.domain.factory;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import br.com.microservices.sales.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactoryImpl implements ProductFactory {

    @Override
    public Product create(String code, double unitValue) {
        return CommonProduct.builder()
                .code(code)
                .unitValue(unitValue)
                .build();
    }

}
