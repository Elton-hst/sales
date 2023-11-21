package br.com.microservices.sales.domain.product.repository;

import br.com.microservices.sales.domain.configs.repository.CrudRepository;
import br.com.microservices.sales.domain.product.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
