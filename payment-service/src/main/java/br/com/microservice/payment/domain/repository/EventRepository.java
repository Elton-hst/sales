package br.com.microservice.payment.domain.repository;

import br.com.microservice.payment.domain.configs.repository.CrudRepository;
import br.com.microservice.payment.domain.entity.Event;

import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, UUID> {

}
