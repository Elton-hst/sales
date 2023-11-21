package br.com.microservices.sales.domain.configs.repository;

import java.util.Optional;

public interface CrudRepository<T, ID> {

    Optional<T> add(T t);

}
