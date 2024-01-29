package br.com.microservices.orchestrator.persistence.dao;

import br.com.microservices.orchestrator.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityDao extends JpaRepository<ProductEntity, String> {

}
