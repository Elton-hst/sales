package br.com.microservices.sales.domain.order.dto;

import br.com.microservices.sales.domain.orderProduct.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder @Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdadeOrderDto {

    private List<OrderProduct> products;

}
