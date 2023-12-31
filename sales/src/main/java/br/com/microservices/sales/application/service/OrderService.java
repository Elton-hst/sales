package br.com.microservices.sales.application.service;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.common.CommonProduct;

import java.util.List;

public interface OrderService {

    CommonOrder create(List<CommonProduct> productList);

}
