package br.com.microservices.orchestrator.domain.repository;

import br.com.microservices.orchestrator.domain.configs.repository.CrudRepository;
import br.com.microservices.orchestrator.domain.entity.Product;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

}
