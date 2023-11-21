package br.com.microservices.sales.infrastructure.persistence.dao;

import br.com.microservices.sales.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityDao extends JpaRepository<OrderEntity, String> {

}
