package br.com.microservices.sales.domain.repository;

import br.com.microservices.sales.application.common.CommonOrder;
import br.com.microservices.sales.domain.configs.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<CommonOrder, UUID> {

}
