package br.com.microservices.inventory.domain.repository;

import br.com.microservices.inventory.domain.configs.repository.CrudRepository;
import br.com.microservices.inventory.domain.entity.Product;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

}
