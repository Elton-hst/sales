package br.com.microservices.sales.domain.configs.presenter;

import java.util.Optional;
import java.util.UUID;

public interface Presenter<T> {

    Optional<T> successView(UUID id);

    Optional<T> failView(String error);

}
