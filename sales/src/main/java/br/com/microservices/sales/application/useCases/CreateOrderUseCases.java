package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.exception.OrderException;
import br.com.microservices.sales.application.service.OrderService;
import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.domain.validator.CreateUpdateOrderDtoValidator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CreateOrderUseCases implements OrderService {

    private final OrderRepository repository;
    private final CreateProductUseCase createProductUseCase;
    private final OrderFactory orderFactory;
    private final CreateEventUseCases createEventUseCases;
    public CreateOrderUseCases(OrderRepository repository, CreateProductUseCase createProductUseCase, OrderFactory orderFactory, CreateEventUseCases createEventUseCases) {
        this.repository = repository;
        this.createProductUseCase = createProductUseCase;
        this.orderFactory = orderFactory;
        this.createEventUseCases = createEventUseCases;
    }

    public CommonOrder create(List<CommonProduct> products) {
        var newProducts = createProductUseCase.create(products);
        var create = orderFactory.create(newProducts);
        Validator.validate(new CreateUpdateOrderDtoValidator(), create);
        var order = add(create);
        //createEvent(order);
        return add(order);
    }

    private CommonOrder add(CommonOrder order) {
        CommonOrder newOrder = CommonOrder.builder()
                .products(order.getProducts())
                .transactionId(generateTransactionId())
                .createdAt(LocalDateTime.now())
                .build();

        return repository.add(newOrder)
                .orElseThrow(() -> new OrderException("Error while trying to create an Order"));
    }

    private void createEvent(CommonOrder order) {
        var event = createEventUseCases.create(order);
    }

    private static String generateTransactionId() {
        return String.format("%s_%s", Instant.now().toEpochMilli(), UUID.randomUUID());
    }
}
