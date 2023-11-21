package br.com.microservices.sales.infrastructure.persistence.dao;

import br.com.microservices.sales.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityDao extends JpaRepository<ProductEntity, String> {

}
