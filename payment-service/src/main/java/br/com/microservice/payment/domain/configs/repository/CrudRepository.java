package br.com.microservice.payment.domain.configs.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CrudRepository<T, ID> {

    Optional<T> add(T t);
    Optional<T> findById(UUID id);
    List<T> findAll();


}
