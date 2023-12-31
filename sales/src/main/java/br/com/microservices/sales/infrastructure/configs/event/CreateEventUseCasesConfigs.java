package br.com.microservices.sales.infrastructure.configs.event;

import br.com.microservices.sales.application.useCases.CreateEventUseCases;
import br.com.microservices.sales.domain.repository.EventRepository;
import br.com.microservices.sales.infrastructure.message.producer.SagaProducer;
import br.com.microservices.sales.infrastructure.utils.JsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateEventUseCasesConfigs {

    @Bean
    public CreateEventUseCases createEventUseCases(EventRepository repository, SagaProducer producer, JsonUtil jsonUtil) {
        return new CreateEventUseCases(repository, producer, jsonUtil);
    }

}
