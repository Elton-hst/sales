package br.com.microservices.sales.domain.order.dto;

import br.com.microservices.sales.domain.orderProduct.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder @Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderDto {

    private List<OrderProduct> products;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

}
