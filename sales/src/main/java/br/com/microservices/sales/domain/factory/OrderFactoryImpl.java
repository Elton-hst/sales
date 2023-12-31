package br.com.microservices.sales.domain.factory;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFactoryImpl implements OrderFactory {

    @Override
    public CommonOrder create(List<CommonProduct> products) {
        return CommonOrder.builder()
                .products(products)
                .build();
    }
}
