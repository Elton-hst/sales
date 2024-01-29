package br.com.microservice.payment.domain.factory;

import br.com.microservice.payment.domain.configs.factory.ProductFactory;
import br.com.microservice.payment.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactoryImpl implements ProductFactory {

    @Override
    public Product create(String code, double unitValue) {
        return new Product(code, unitValue);
    }

}
