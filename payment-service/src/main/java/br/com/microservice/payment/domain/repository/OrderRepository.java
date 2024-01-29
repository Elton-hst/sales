package br.com.microservice.payment.domain.repository;

import br.com.microservice.payment.domain.configs.repository.CrudRepository;
import br.com.microservice.payment.domain.entity.Order;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {

}
