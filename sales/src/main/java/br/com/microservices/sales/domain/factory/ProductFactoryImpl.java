package br.com.microservices.sales.domain.factory;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.configs.factory.IProductFactory;
import br.com.microservices.sales.infrastructure.exception.ProductException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductFactory implements IProductFactory {

    @Override
    public List<CommonProduct> create(List<CommonProduct> products) {
        List<CommonProduct> commonProductList = new ArrayList<>();

        for (CommonProduct product: products) {

            switch (product.code()) {
                case "livro" -> commonProductList.add(product);
                case "quandrinhos" -> commonProductList.add(product);
                case "filme" -> commonProductList.add(product);
                default -> throw new ProductException("valor invalido");
            };

        }

        return commonProductList;
    }

}
