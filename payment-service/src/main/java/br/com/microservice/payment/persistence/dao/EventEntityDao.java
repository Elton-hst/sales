package br.com.microservice.payment.persistence.dao;

import br.com.microservice.payment.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventEntityDao extends JpaRepository<EventEntity, UUID> {

}
