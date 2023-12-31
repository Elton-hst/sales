package br.com.microservices.sales.domain.configs.factory;

import br.com.microservices.sales.domain.entity.Product;

public interface ProductFactory {

    Product create(String code, double unitValue);

}
