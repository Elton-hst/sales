package br.com.microservices.sales.domain.configs.factory;

import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.web.request.CreateUpdadeOrderDto;

public interface OrderFactory {

    Order create(CreateUpdadeOrderDto orderDto);

}
