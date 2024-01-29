package br.com.microservices.orchestrator.application.useCases;

import br.com.microservices.orchestrator.domain.configs.factory.OrderFactory;
import br.com.microservices.orchestrator.domain.configs.validation.Validator;
import br.com.microservices.orchestrator.domain.entity.Order;
import br.com.microservices.orchestrator.domain.validator.CreateUpdateOrderDtoValidator;
import br.com.microservices.orchestrator.web.request.CreateUpdadeOrderDto;
import br.com.microservices.orchestrator.web.request.CreateUpdateEventDto;
import br.com.microservices.orchestrator.web.request.CreateUpdateProductDto;
import br.com.microservices.orchestrator.web.response.GetEventDto;
import br.com.microservices.orchestrator.web.response.GetProductDto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreateOrderUseCases {

    private final OrderFactory orderFactory;
    private final CreateProductUseCase productUseCase;
    private final CreateEventUseCases createEventUseCases;
    public CreateOrderUseCases(OrderFactory orderFactory, CreateProductUseCase productUseCase, CreateEventUseCases createEventUseCases) {
        this.orderFactory = orderFactory;
        this.productUseCase = productUseCase;
        this.createEventUseCases = createEventUseCases;
    }

    public GetEventDto create(Set<CreateUpdateProductDto> productDto) {
        var newProduct = createProduct(productDto);
        CreateUpdadeOrderDto orderDto = new CreateUpdadeOrderDto(newProduct.stream()
                .map(GetProductDto::toProduct).collect(Collectors.toSet()));
        var order = this.orderFactory.create(orderDto);
        Validator.validate(new CreateUpdateOrderDtoValidator(), order);
        var newOrder = add(order).toOrderDto();
        return createEvent(newOrder.toOrder());
    }

    private Order add(Order order) {
        return new Order(
                order.products(),
                LocalDateTime.now(),
                generateTransactionId()
        );
    }

    private Set<GetProductDto> createProduct(Set<CreateUpdateProductDto> productDto) {
        return productUseCase.create(productDto);
    }

    private GetEventDto createEvent(Order order) {
        CreateUpdateEventDto eventDto = new CreateUpdateEventDto(order);
        return createEventUseCases.create(eventDto);
    }

    private static String generateTransactionId() {
        return String.format("%s_%s", Instant.now().toEpochMilli(), UUID.randomUUID());
    }
}
