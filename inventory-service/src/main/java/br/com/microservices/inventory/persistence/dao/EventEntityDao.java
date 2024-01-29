package br.com.microservices.inventory.persistence.dao;

import br.com.microservices.inventory.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventEntityDao extends JpaRepository<EventEntity, UUID> {

}
