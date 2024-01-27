package br.com.microservices.sales.domain.configs.factory;

import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.domain.entity.Product;

import java.util.Set;

public interface OrderFactory {

    Order create(Set<Product> products);

}
