package br.com.microservices.sales.persistence.dao;

import br.com.microservices.sales.persistence.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoryEntityDao extends JpaRepository<HistoryEntity, UUID> {

}
