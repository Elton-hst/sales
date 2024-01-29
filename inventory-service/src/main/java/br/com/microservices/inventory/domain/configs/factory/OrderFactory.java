package br.com.microservices.inventory.domain.configs.factory;

import br.com.microservices.inventory.domain.entity.Order;
import br.com.microservices.inventory.web.request.CreateUpdadeOrderDto;

public interface OrderFactory {

    Order create(CreateUpdadeOrderDto orderDto);

}
