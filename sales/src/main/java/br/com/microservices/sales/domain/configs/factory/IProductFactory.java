package br.com.microservices.sales.domain.configs.factory;

import br.com.microservices.sales.domain.common.CommonProduct;

import java.util.List;

public interface IProductFactory {

    List<CommonProduct> create(List<CommonProduct> products);

}
