package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.factory.ProductFactoryImpl;
import br.com.microservices.sales.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class CreateOrderUseCasesTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CreateProductUseCase createProductUseCase;

    @Mock
    private ProductFactoryImpl productFactoryImpl;

    @InjectMocks
    private CreateOrderUseCases createOrderUseCases;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Create Order Use Cases - Successful Order Creation")
    void createOrder_successfulOrderCreation() {

        List<CommonProduct> inputProducts = new ArrayList<>();
        List<CommonProduct> createdProducts = new ArrayList<>();

        CommonProduct product = CommonProduct.builder()
                .code("livro")
                .unitValue(20)
                .build();

        createdProducts.add(product);
        inputProducts.add(product);

        when(productFactoryImpl.create(anyList())).thenReturn(createdProducts);

        when(createProductUseCase.create(createdProducts)).thenReturn(createdProducts);

        CommonOrder expectedOrder = CommonOrder.builder()
                .products(inputProducts)
                .build();

        when(orderRepository.add(any(CommonOrder.class))).thenReturn(Optional.of(expectedOrder));

        CommonOrder result = createOrderUseCases.create(inputProducts);

        verify(createProductUseCase, times(1)).create(createdProducts);

        verify(orderRepository, times(1)).add(any(CommonOrder.class));

        assertEquals(expectedOrder, result);
    }
}

