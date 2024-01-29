package br.com.microservices.inventory.domain.factory;

import br.com.microservices.inventory.domain.configs.factory.OrderFactory;
import br.com.microservices.inventory.domain.entity.Order;
import br.com.microservices.inventory.web.request.CreateUpdadeOrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactoryImpl implements OrderFactory {

    @Override
    public Order create(CreateUpdadeOrderDto orderDto) {
        return new Order(orderDto.products());
    }
}
