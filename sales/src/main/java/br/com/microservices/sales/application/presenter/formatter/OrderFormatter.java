package br.com.microservices.sales.application.presenter.formatter;

import br.com.microservices.sales.application.common.CommonOrder;
import br.com.microservices.sales.application.presenter.OrderPresenter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class OrderFormatter implements OrderPresenter {

    @Override
    public Optional<CommonOrder> successView(CommonOrder order) {
        LocalDateTime time = LocalDateTime.parse(order.getCreatedAt().toString());
        //CommonOrder commonOrder = CommonOrder.builder(time.).createdAt().build();
        return Optional.empty();
    }

    @Override
    public Optional<CommonOrder> failView(String error) {
        return Optional.empty();
    }

}
