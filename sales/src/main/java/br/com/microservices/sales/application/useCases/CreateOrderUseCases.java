package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.common.CommonOrder;
import br.com.microservices.sales.application.exception.OrderException;
import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.configs.validation.Validator;
import br.com.microservices.sales.domain.entity.Order;
import br.com.microservices.sales.domain.entity.Product;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.domain.validator.CreateUpdateOrderDtoValidator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class CreateOrderUseCases {

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

    public Order create(Set<Product> products) {
        var newProducts = this.createProductUseCase.create(products);
        var create = this.orderFactory.create(newProducts);
        Validator.validate(new CreateUpdateOrderDtoValidator(), create);
        return add(create);
    }

    private CommonOrder add(Order order) {
        CommonOrder newOrder = CommonOrder.builder()
                .products(order.getProducts())
                .transactionId(generateTransactionId())
                .createdAt(LocalDateTime.now()).build();

        return this.repository.add(newOrder)
                .orElseThrow(() -> new OrderException("Error while trying to create an Order"));
    }

    private void createEvent(CommonOrder order) {
        var event = createEventUseCases.create(order);
    }

    private static String generateTransactionId() {
        return String.format("%s_%s", Instant.now().toEpochMilli(), UUID.randomUUID());
    }
}
