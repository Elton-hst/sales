package br.com.microservices.sales.application.facede;

import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OrderFacede {

    private final CreateOrderUseCases createOrderUseCases;

    public OrderFacede(CreateOrderUseCases createOrderUseCases) {
        this.createOrderUseCases = createOrderUseCases;
    }

    public Order createOrder(Set<Product> products){
        return createOrderUseCases.create(products);
    }
}
