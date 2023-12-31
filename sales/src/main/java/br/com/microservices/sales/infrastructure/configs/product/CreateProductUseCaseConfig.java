package br.com.microservices.sales.infrastructure.configs.product;

import br.com.microservices.sales.application.useCases.CreateProductUseCase;
import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import br.com.microservices.sales.domain.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateProductUseCaseConfig {
    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository repository, ProductFactory factory) {
        return new CreateProductUseCase(repository, factory);
    }
}
