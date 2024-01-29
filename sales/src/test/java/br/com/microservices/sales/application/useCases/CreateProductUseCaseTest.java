package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.domain.configs.factory.ProductFactory;
import br.com.microservices.sales.domain.repository.ProductRepository;
import br.com.microservices.sales.domain.validator.CreateUpdateProductsDtoValidator;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CreateProductUseCaseTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductFactory productFactory;

    @Mock
    private CreateUpdateProductsDtoValidator validator;

    @InjectMocks
    private CreateProductUseCase createProductUseCase;

//    @Test
//    public void testCreateProduct() {
//        // Mocking
//        CommonProduct commonProduct = CommonProduct.builder()
//                .code("ABC123")
//                .unitValue(10.0)
//                .build();
//
//        Product product = mock(Product.class);
//        when(productFactory.create("ABC123", 10.0)).thenReturn(product);
//        when(repository.add(any(CommonProduct.class))).thenReturn(Optional.of(commonProduct));
//
//        // Teste
//        List<CommonProduct> productList = createProductUseCase.create(Collections.singletonList(commonProduct));
//
//        // Verificação
//        assertEquals(productList.size(), 1);
//        assertEquals(productList.get(0).getCode(), "ABC123");
//        assertEquals(productList.get(0).getUnitValue(), 10.0);
//    }
//
//    @Test
//    public void testCreateProductException() {
//        // Mocking
//        CommonProduct commonProduct = CommonProduct.builder()
//                .code("ABC123")
//                .unitValue(10.0)
//                .build();
//
//        Product product = mock(Product.class);
//        when(productFactory.create("ABC123", 10.0)).thenReturn(product);
//        when(repository.add(any(CommonProduct.class))).thenReturn(Optional.empty());
//
//        // Teste
//        createProductUseCase.create(Collections.singletonList(commonProduct));
//    }
}

