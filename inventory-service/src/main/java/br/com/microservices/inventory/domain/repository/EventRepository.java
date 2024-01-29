package br.com.microservices.inventory.domain.repository;

import br.com.microservices.inventory.domain.configs.repository.CrudRepository;
import br.com.microservices.inventory.domain.entity.Event;

import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, UUID> {

}
