package br.com.microservice.payment.domain.factory;

import br.com.microservice.payment.domain.configs.factory.OrderFactory;
import br.com.microservice.payment.domain.entity.Order;
import br.com.microservice.payment.web.request.CreateUpdadeOrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderFactoryImpl implements OrderFactory {

    @Override
    public Order create(CreateUpdadeOrderDto orderDto) {
        return new Order(orderDto.products());
    }
}
