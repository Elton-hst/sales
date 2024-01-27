package br.com.microservices.sales.domain.factory;

import br.com.microservices.sales.application.common.CommonProduct;
import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFactoryImpl implements ProductFactory {

    @Override
    public CommonProduct create(String code, double unitValue) {
        return CommonProduct.builder()
                .code(code)
                .unitValue(unitValue)
                .build();
    }

}
