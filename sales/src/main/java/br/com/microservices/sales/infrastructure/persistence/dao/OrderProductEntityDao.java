package br.com.microservices.sales.infrastructure.persistence.dao;

import br.com.microservices.sales.infrastructure.persistence.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductEntityDao extends JpaRepository<OrderProductEntity, String> {

}
