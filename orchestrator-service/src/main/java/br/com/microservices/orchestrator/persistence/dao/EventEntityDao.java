package br.com.microservices.orchestrator.persistence.dao;

import br.com.microservices.orchestrator.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventEntityDao extends JpaRepository<EventEntity, UUID> {

}
