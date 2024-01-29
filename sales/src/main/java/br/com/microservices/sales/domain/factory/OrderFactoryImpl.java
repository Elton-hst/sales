package br.com.microservices.sales.domain.factory;

import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.web.request.CreateUpdadeOrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactoryImpl implements OrderFactory {

    @Override
    public Order create(CreateUpdadeOrderDto orderDto) {
        return new Order(orderDto.products());
    }
}
