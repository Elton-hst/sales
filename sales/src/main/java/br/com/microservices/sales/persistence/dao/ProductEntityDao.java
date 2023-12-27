package br.com.microservices.sales.persistence.dao;

import br.com.microservices.sales.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityDao extends JpaRepository<ProductEntity, String> {

}
