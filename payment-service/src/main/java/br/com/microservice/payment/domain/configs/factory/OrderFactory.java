package br.com.microservice.payment.domain.configs.factory;

import br.com.microservice.payment.domain.entity.Order;
import br.com.microservice.payment.web.request.CreateUpdadeOrderDto;

public interface OrderFactory {

    Order create(CreateUpdadeOrderDto orderDto);

}
