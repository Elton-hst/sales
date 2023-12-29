package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.exception.ProductException;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateProductUseCaseTest {

    @Mock
    private ProductRepository repository;

    @Test
    void create_shouldCreateProductsSuccessfully() {

        MockitoAnnotations.openMocks(this);
        CreateProductUseCase createProductUseCase = new CreateProductUseCase(repository);

        List<CommonProduct> inputProducts = List.of(
                CommonProduct.builder().code("ABC").unitValue(10.0).build(),
                CommonProduct.builder().code("DEF").unitValue(20.0).build()
        );

        List<CommonProduct> expectedProducts = new ArrayList<>();
        for (CommonProduct inputProduct : inputProducts) {
            expectedProducts.add(CommonProduct.builder()
                    .id(inputProduct.id())
                    .code(inputProduct.code())
                    .unitValue(inputProduct.unitValue())
                    .build());
        }

        when(repository.add(any(CommonProduct.class))).thenReturn(Optional.of(CommonProduct.builder().build()));

        List<CommonProduct> createdProducts = createProductUseCase.create(inputProducts);

        assertEquals(expectedProducts, createdProducts);
    }

    @Test
    void create_shouldThrowExceptionWhenRepositoryFails() {

        MockitoAnnotations.openMocks(this);
        CreateProductUseCase createProductUseCase = new CreateProductUseCase(repository);

        List<CommonProduct> inputProducts = List.of(
                CommonProduct.builder().code("ABC").unitValue(10.0).build(),
                CommonProduct.builder().code("DEF").unitValue(20.0).build()
        );

        when(repository.add(any(CommonProduct.class))).thenReturn(Optional.empty());

        assertThrows(ProductException.class, () -> createProductUseCase.create(inputProducts));
    }
}

