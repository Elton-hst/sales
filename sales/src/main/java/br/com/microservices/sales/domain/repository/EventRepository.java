package br.com.microservices.sales.domain.repository;

import br.com.microservices.sales.domain.configs.repository.CrudRepository;
import br.com.microservices.sales.domain.entity.Event;

import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, UUID> {

}
