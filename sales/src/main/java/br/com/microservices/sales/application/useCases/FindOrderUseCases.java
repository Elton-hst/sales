package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.service.OrderService;
import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.web.response.GetOrderDto;
import br.com.microservices.sales.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public abstract class FindOrderUseCases implements OrderService {

    private final OrderRepository repository;
    protected FindOrderUseCases(OrderRepository repository) {
        this.repository = repository;
    }

    public List<GetOrderDto> findAll(){
        List<CommonOrder> order = repository.findAll();
        return order
                .stream()
                .map(CommonOrder::getOrderDto)
                .collect(Collectors.toList());
    }

}