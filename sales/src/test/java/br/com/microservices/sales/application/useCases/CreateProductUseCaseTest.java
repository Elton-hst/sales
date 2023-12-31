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

//        MockitoAnnotations.openMocks(this);
//        CreateProductUseCase createProductUseCase = new CreateProductUseCase(repository);
//
//        List<CommonProduct> inputProducts = List.of(
//                new CommonProduct("ABC", 10),
//                new CommonProduct("DEF", 20)
//        );
//
//        List<CommonProduct> expectedProducts = new ArrayList<>();
//        for (CommonProduct inputProduct : inputProducts) {
//            expectedProducts.add(new CommonProduct(inputProduct.getCode(), inputProduct.getUnitValue()));
//        }
//
//        when(repository.add(any(CommonProduct.class))).thenReturn(Optional.of(new CommonProduct());
//
//        List<CommonProduct> createdProducts = createProductUseCase.create(inputProducts);
//
//        assertEquals(expectedProducts, createdProducts);
    }

    @Test
    void create_shouldThrowExceptionWhenRepositoryFails() {

//        MockitoAnnotations.openMocks(this);
//        CreateProductUseCase createProductUseCase = new CreateProductUseCase(repository);
//
//        List<CommonProduct> inputProducts = List.of(
//                new CommonProduct("ABC", 10),
//                new CommonProduct("DEF", 20)
//        );
//
//        when(repository.add(any(CommonProduct.class))).thenReturn(Optional.empty());
//
//        assertThrows(ProductException.class, () -> createProductUseCase.create(inputProducts));
    }
}

