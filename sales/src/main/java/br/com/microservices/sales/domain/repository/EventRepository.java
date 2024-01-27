package br.com.microservices.sales.domain.repository;

import br.com.microservices.sales.application.common.CommonEvent;
import br.com.microservices.sales.domain.configs.repository.CrudRepository;

import java.util.UUID;

public interface EventRepository extends CrudRepository<CommonEvent, UUID> {

}
