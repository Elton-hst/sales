package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import br.com.microservices.sales.domain.factory.ProductFactoryImpl;
import br.com.microservices.sales.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

class CreateOrderUseCasesTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CreateProductUseCase createProductUseCase;

    @Mock
    private ProductFactory productFactory;

    @InjectMocks
    private CreateOrderUseCases createOrderUseCases;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Create Order Use Cases - Successful Order Creation")
    void createOrder_successfulOrderCreation() {

//        List<CommonProduct> inputProducts = new ArrayList<>();
//        List<CommonProduct> createdProducts = new ArrayList<>();
//
//        CommonProduct product = new CommonProduct("livro", 20);
//
//        createdProducts.add(product);
//        inputProducts.add(product);
//
//        when(productFactory.create(anyList())).thenReturn(createdProducts);
//
//        when(createProductUseCase.create(createdProducts)).thenReturn(createdProducts);
//
//        CommonOrder expectedOrder = CommonOrder.builder()
//                .products(inputProducts)
//                .build();
//
//        when(orderRepository.add(any(CommonOrder.class))).thenReturn(Optional.of(expectedOrder));
//
//        CommonOrder result = createOrderUseCases.create(inputProducts);
//
//        verify(createProductUseCase, times(1)).create(createdProducts);
//
//        verify(orderRepository, times(1)).add(any(CommonOrder.class));
//
//        assertEquals(expectedOrder, result);
    }
}

