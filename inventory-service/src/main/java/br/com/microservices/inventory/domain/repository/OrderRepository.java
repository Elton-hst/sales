package br.com.microservices.inventory.domain.repository;

import br.com.microservices.inventory.domain.configs.repository.CrudRepository;
import br.com.microservices.inventory.domain.entity.Order;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {

}
