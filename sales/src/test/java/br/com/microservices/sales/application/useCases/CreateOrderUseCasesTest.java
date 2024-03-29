package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.domain.configs.factory.OrderFactory;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.domain.validator.CreateUpdateOrderDtoValidator;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CreateOrderUseCasesTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private CreateProductUseCase createProductUseCase;

    @Mock
    private OrderFactory orderFactory;

    @Mock
    private CreateUpdateOrderDtoValidator validator;

    @InjectMocks
    private CreateOrderUseCases createOrderUseCases;

//    @Test
//    public void testCreateOrder() {
//        // Mocking
//        CommonProduct commonProduct = CommonProduct.builder()
//                .code("ABC123")
//                .unitValue(10.0)
//                .build();
//
//        List<CommonProduct> products = Collections.singletonList(commonProduct);
//
//        CommonOrder commonOrder = CommonOrder.builder()
//                .products(products)
//                .transactionId("transactionId")
//                .createdAt(LocalDateTime.now())
//                .build();
//
//        when(createProductUseCase.create(products)).thenReturn(products);
//        when(orderFactory.create(products)).thenReturn(commonOrder);
//        when(repository.add(any(CommonOrder.class))).thenReturn(Optional.of(commonOrder));
//
//        // Teste
//        CommonOrder createdOrder = createOrderUseCases.create(products);
//
//        // Verificação
//        assertEquals(createdOrder.getProducts(), products);
//        assertEquals(createdOrder.getTransactionId(), "transactionId");
//        // Adicione mais verificações conforme necessário
//    }
//
//    @Test
//    public void testCreateOrderException() {
//        // Mocking
//        CommonProduct commonProduct = CommonProduct.builder()
//                .code("ABC123")
//                .unitValue(10.0)
//                .build();
//
//        List<CommonProduct> products = Collections.singletonList(commonProduct);
//
//        CommonOrder commonOrder = CommonOrder.builder()
//                .products(products)
//                .transactionId("transactionId")
//                .createdAt(LocalDateTime.now())
//                .build();
//
//        when(createProductUseCase.create(products)).thenReturn(products);
//        when(orderFactory.create(products)).thenReturn(commonOrder);
//        when(repository.add(any(CommonOrder.class))).thenReturn(Optional.empty());
//
//        // Teste
//        createOrderUseCases.create(products);
//    }

}

