package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.infrastructure.exception.OrderException;
import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.order.Order;
import br.com.microservices.sales.domain.order.dto.CreateUpdadeOrderDto;
import br.com.microservices.sales.domain.order.dto.GetOrderDto;
import br.com.microservices.sales.domain.order.dto.validator.CreateUpdateOrderDtoValidator;
import br.com.microservices.sales.domain.order.repository.OrderRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class CreateOrderUseCases {

    private final OrderRepository repository;
    public CreateOrderUseCases(OrderRepository repository) {
        this.repository = repository;
    }
    private static final String TRANSACTION_ID_PATTERN = "%s_%s";

    public GetOrderDto addOrder(CreateUpdadeOrderDto dto){
        Validator.validate(new CreateUpdateOrderDtoValidator(), dto);
        Order order = Order.builder()
                .products(dto.getProducts())
                .createdAt(LocalDateTime.now())
                .transactionId(String.format(
                        TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()
                ))
                .build();
        return createOrder(order);
    }

    private GetOrderDto createOrder(Order order){
        return repository.add(order)
                .orElseThrow(() -> new OrderException("erro ao tentar criar"))
                .getOrderDto();
    }

}
