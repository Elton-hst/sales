package br.com.microservices.sales.infrastructure.configs;

import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.domain.order.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfigs {
    @Bean
    public CreateOrderUseCases orderService(OrderRepository orderRepository){
        return new CreateOrderUseCases(orderRepository);
    }
}
