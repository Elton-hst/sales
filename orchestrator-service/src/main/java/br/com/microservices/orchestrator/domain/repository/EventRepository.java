package br.com.microservices.orchestrator.domain.repository;

import br.com.microservices.orchestrator.domain.configs.repository.CrudRepository;
import br.com.microservices.orchestrator.domain.entity.Event;

import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, UUID> {

}
