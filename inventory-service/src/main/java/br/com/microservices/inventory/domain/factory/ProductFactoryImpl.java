package br.com.microservices.inventory.domain.factory;

import br.com.microservices.inventory.domain.configs.factory.ProductFactory;
import br.com.microservices.inventory.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactoryImpl implements ProductFactory {

    @Override
    public Product create(String code, double unitValue) {
        return new Product(code, unitValue);
    }

}
