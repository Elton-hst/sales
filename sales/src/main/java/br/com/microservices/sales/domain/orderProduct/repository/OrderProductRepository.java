package br.com.microservices.sales.domain.orderProduct.repository;

import br.com.microservices.sales.domain.configs.repository.CrudRepository;
import br.com.microservices.sales.domain.orderProduct.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, String> {
}
