package br.com.microservices.sales.domain.repository;

import br.com.microservices.sales.application.common.CommonProduct;
import br.com.microservices.sales.domain.configs.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<CommonProduct, UUID> {

}
