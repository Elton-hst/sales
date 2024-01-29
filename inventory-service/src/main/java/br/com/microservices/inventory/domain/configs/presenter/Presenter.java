package br.com.microservices.inventory.domain.configs.presenter;

import java.util.Optional;

public interface Presenter<T> {

    Optional successView(T t);

    Optional<T> failView(String error);

}
