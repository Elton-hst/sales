package br.com.microservices.sales.domain.repository;

import br.com.microservices.sales.domain.common.CommonHistory;
import br.com.microservices.sales.domain.configs.repository.CrudRepository;

import java.util.UUID;

public interface HistoryRepository extends CrudRepository<CommonHistory, UUID> {

}
