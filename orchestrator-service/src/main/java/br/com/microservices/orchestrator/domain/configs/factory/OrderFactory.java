package br.com.microservices.orchestrator.domain.configs.factory;

import br.com.microservices.orchestrator.domain.entity.Order;
import br.com.microservices.orchestrator.web.request.CreateUpdadeOrderDto;

public interface OrderFactory {

    Order create(CreateUpdadeOrderDto orderDto);

}
