package br.com.microservices.sales.infrastructure.configs.event;

import br.com.microservices.sales.application.useCases.CreateEventUseCases;
import br.com.microservices.sales.application.useCases.NotifyEndingUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifyEndingUseCasesConfig {

    @Bean
    public NotifyEndingUseCases notifyEndingUseCases(CreateEventUseCases createEventUseCases){
        return new NotifyEndingUseCases(createEventUseCases);
    }

}
