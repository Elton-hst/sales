package br.com.microservices.sales.infrastructure.configs.order;

import br.com.microservices.sales.application.useCases.CreateEventUseCases;
import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.application.useCases.CreateProductUseCase;
import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateOrderUseCasesConfigs {
    @Bean
    public CreateOrderUseCases createOrderUseCases(OrderRepository repository, CreateProductUseCase createProductUseCase, OrderFactory orderFactory, CreateEventUseCases createEventUseCases){
        return new CreateOrderUseCases(repository, createProductUseCase, orderFactory, createEventUseCases);
    }
}
