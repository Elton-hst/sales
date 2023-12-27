package br.com.microservices.sales.infrastructure.configs.order;

import br.com.microservices.sales.application.useCases.FindOrderUseCases;
import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FindOrderUseCasesConfigs {

    @Bean
    public FindOrderUseCases findOrderUseCases(OrderRepository orderRepository){
        return new FindOrderUseCases(orderRepository) {
            @Override
            public CommonOrder create(List<CommonProduct> productList) {
                return null;
            }
        };
    }

}
