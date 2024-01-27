package br.com.microservices.sales.persistence.dao;

import br.com.microservices.sales.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, UUID> {
}
