package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.service.OrderService;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.factory.ProductFactory;
import br.com.microservices.sales.infrastructure.exception.OrderException;
import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.repository.OrderRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class CreateOrderUseCases implements OrderService {

    private final OrderRepository repository;
    private final CreateProductUseCase createProductUseCase;
    private final ProductFactory productFactory;
    protected CreateOrderUseCases(OrderRepository repository, CreateProductUseCase createProductUseCase, ProductFactory productFactory) {
        this.repository = repository;
        this.createProductUseCase = createProductUseCase;
        this.productFactory = productFactory;
    }

    @Override
    public CommonOrder create(List<CommonProduct> products) {
        var productList = productFactory.create(products);
        var newProducts = createProductUseCase.create(productList);

        CommonOrder order = CommonOrder.builder()
                .products(newProducts)
                .createdAt(LocalDateTime.now())
                .transactionId(generateTransactionId())
                .build();

        return createOrder(order);
    }

    private static String generateTransactionId() {
        return String.format("%s_%s", Instant.now().toEpochMilli(), UUID.randomUUID());
    }

    private CommonOrder createOrder(CommonOrder order) {
        return repository.add(order)
                .orElseThrow(() -> new OrderException("Error while trying to create an Order"));
    }
}
