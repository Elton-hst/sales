package br.com.microservices.sales.infrastructure.configs.order;

import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.application.useCases.CreateProductUseCase;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.domain.factory.ProductFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateOrderUseCasesConfigs {
    @Bean
    public CreateOrderUseCases createOrderUseCases(OrderRepository orderRepository, CreateProductUseCase createProductUseCase, ProductFactoryImpl productFactoryImpl){
        return new CreateOrderUseCases(orderRepository, createProductUseCase, productFactoryImpl);
    }
}
