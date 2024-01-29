package br.com.microservices.sales.infrastructure.configs;

import br.com.microservices.sales.application.useCases.CreateEventUseCases;
import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.application.useCases.CreateProductUseCase;
import br.com.microservices.sales.application.useCases.NotifyEndingUseCases;
import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import br.com.microservices.sales.domain.repository.EventRepository;
import br.com.microservices.sales.infrastructure.message.producer.SagaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public CreateOrderUseCases createOrderUseCases(OrderFactory orderFactory, CreateProductUseCase productUseCase, CreateEventUseCases createEventUseCases){
        return new CreateOrderUseCases( orderFactory, productUseCase, createEventUseCases);
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductFactory factory) {
        return new CreateProductUseCase(factory);
    }

    @Bean
    public CreateEventUseCases createEventUseCases(EventRepository repository, SagaProducer sagaProducer) {
        return new CreateEventUseCases(repository, sagaProducer);
    }

    @Bean
    public NotifyEndingUseCases notifyEndingUseCases(){
        return new NotifyEndingUseCases();
    }

}
