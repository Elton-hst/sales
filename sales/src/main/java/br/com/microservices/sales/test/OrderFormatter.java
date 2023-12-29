package br.com.microservices.sales.test;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.presenter.OrderPresenter;

import java.util.Optional;
import java.util.UUID;

public class OrderFormatter implements OrderPresenter {


    @Override
    public Optional<CommonOrder> successView(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<CommonOrder> failView(String error) {
        return Optional.empty();
    }
}
