package br.com.microservices.sales.application.facede;

import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.web.request.CreateUpdateProductDto;
import br.com.microservices.sales.web.response.GetEventDto;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OrderFacede {

    private final CreateOrderUseCases createOrderUseCases;

    public OrderFacede(CreateOrderUseCases createOrderUseCases) {
        this.createOrderUseCases = createOrderUseCases;
    }

    public GetEventDto createOrder(Set<CreateUpdateProductDto> products){
        return createOrderUseCases.create(products);
    }
}
