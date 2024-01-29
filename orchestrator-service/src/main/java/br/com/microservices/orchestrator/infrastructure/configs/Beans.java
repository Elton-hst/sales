package br.com.microservices.orchestrator.infrastructure.configs;

import br.com.microservices.orchestrator.application.useCases.CreateEventUseCases;
import br.com.microservices.orchestrator.application.useCases.CreateOrderUseCases;
import br.com.microservices.orchestrator.application.useCases.CreateProductUseCase;
import br.com.microservices.orchestrator.application.useCases.NotifyEndingUseCases;
import br.com.microservices.orchestrator.domain.configs.factory.OrderFactory;
import br.com.microservices.orchestrator.domain.configs.factory.ProductFactory;
import br.com.microservices.orchestrator.domain.repository.EventRepository;
import br.com.microservices.orchestrator.infrastructure.message.producer.SagaProducer;
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
