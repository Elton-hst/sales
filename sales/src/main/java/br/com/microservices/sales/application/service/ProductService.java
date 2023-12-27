package br.com.microservices.sales.application.service;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.entity.Product;

import java.util.List;

public interface ProductService {

    List<CommonProduct> create(List<CommonProduct> product);

}
