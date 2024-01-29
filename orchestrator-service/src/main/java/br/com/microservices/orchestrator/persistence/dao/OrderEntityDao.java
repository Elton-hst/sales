package br.com.microservices.orchestrator.persistence.dao;

import br.com.microservices.orchestrator.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderEntityDao extends JpaRepository<OrderEntity, UUID> {

}
