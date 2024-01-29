package br.com.microservice.payment.domain.configs.factory;

import br.com.microservice.payment.domain.entity.Product;

public interface ProductFactory {

    Product create(String code, double unitValue);

}
