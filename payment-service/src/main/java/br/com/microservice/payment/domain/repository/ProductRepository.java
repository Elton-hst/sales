package br.com.microservice.payment.domain.repository;

import br.com.microservice.payment.domain.configs.repository.CrudRepository;
import br.com.microservice.payment.domain.entity.Product;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

}
