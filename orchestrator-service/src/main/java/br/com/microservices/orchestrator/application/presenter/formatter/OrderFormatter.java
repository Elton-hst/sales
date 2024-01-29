package br.com.microservices.orchestrator.application.presenter.formatter;

import br.com.microservices.orchestrator.application.presenter.OrderPresenter;
import br.com.microservices.orchestrator.domain.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class OrderFormatter implements OrderPresenter {

    @Override
    public Optional<Order> successView(Order order) {
        LocalDateTime time = LocalDateTime.parse(order.createdAt().toString());
        return Optional.empty();
    }

    @Override
    public Optional<Order> failView(String error) {
        return Optional.empty();
    }

}
