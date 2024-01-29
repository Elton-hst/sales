package br.com.microservices.sales.domain.repository;

import br.com.microservices.sales.domain.configs.repository.CrudRepository;
import br.com.microservices.sales.domain.entity.Product;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

}
