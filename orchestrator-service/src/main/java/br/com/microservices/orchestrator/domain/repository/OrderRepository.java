package br.com.microservices.orchestrator.domain.repository;

import br.com.microservices.orchestrator.domain.configs.repository.CrudRepository;
import br.com.microservices.orchestrator.domain.entity.Order;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {

}
