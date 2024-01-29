package br.com.microservices.orchestrator.domain.configs.factory;

import br.com.microservices.orchestrator.domain.entity.Product;

public interface ProductFactory {

    Product create(String code, double unitValue);

}
