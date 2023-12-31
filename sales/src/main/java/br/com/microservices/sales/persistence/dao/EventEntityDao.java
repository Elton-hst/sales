package br.com.microservices.sales.persistence.dao;

import br.com.microservices.sales.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventEntityDao extends JpaRepository<EventEntity, UUID> {

}
