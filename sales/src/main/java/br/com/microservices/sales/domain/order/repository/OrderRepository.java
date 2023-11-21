package br.com.microservices.sales.domain.order.repository;

import br.com.microservices.sales.domain.configs.repository.CrudRepository;
import br.com.microservices.sales.domain.order.Order;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, String> {

}
