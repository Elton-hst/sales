package br.com.microservices.sales.domain.presenter.formatter;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.presenter.OrderPresenter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
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
