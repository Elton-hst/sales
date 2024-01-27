package br.com.microservices.sales.domain.factory;

import br.com.microservices.sales.application.common.CommonOrder;
import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OrderFactoryImpl implements OrderFactory {

    @Override
    public Order create(Set<Product> products) {
        return CommonOrder.builder().products(products).build();
    }
}
