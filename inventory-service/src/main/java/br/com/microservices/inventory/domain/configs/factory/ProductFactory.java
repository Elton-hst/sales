package br.com.microservices.inventory.domain.configs.factory;

import br.com.microservices.inventory.domain.entity.Product;

public interface ProductFactory {

    Product create(String code, double unitValue);

}
