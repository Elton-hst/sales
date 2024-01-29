package br.com.microservices.inventory.persistence.dao;

import br.com.microservices.inventory.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityDao extends JpaRepository<ProductEntity, String> {

}
