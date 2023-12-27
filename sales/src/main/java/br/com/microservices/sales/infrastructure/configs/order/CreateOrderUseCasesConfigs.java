package br.com.microservices.sales.infrastructure.configs.order;

import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.application.useCases.CreateProductUseCase;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.domain.factory.ProductFactory;
import br.com.microservices.sales.web.response.GetOrderDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CreateOrderUseCasesConfigs {
    @Bean
    public CreateOrderUseCases createOrderUseCases(OrderRepository orderRepository, CreateProductUseCase createProductUseCase, ProductFactory productFactory){
        return new CreateOrderUseCases(orderRepository, createProductUseCase, productFactory) {
            @Override
            public List<GetOrderDto> findAll() {
                return null;
            }
        };
    }
}
