package br.com.microservice.payment.persistence.dao;

import br.com.microservice.payment.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityDao extends JpaRepository<ProductEntity, String> {

}
