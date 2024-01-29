package br.com.microservices.orchestrator.domain.factory;

import br.com.microservices.orchestrator.domain.configs.factory.OrderFactory;
import br.com.microservices.orchestrator.domain.entity.Order;
import br.com.microservices.orchestrator.web.request.CreateUpdadeOrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactoryImpl implements OrderFactory {

    @Override
    public Order create(CreateUpdadeOrderDto orderDto) {
        return new Order(orderDto.products());
    }
}
