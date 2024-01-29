package br.com.microservice.payment.application.facede;

import br.com.microservice.payment.application.useCases.CreateOrderUseCases;
import br.com.microservice.payment.web.request.CreateUpdateProductDto;
import br.com.microservice.payment.web.response.GetEventDto;
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
