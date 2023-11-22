package br.com.microservices.sales.domain.order;

import br.com.microservices.sales.domain.order.dto.GetOrderDto;
import br.com.microservices.sales.domain.orderProduct.OrderProduct;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder @Data
@EqualsAndHashCode
public class Order {

    private UUID id;
    private List<OrderProduct> products;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

    public GetOrderDto getOrderDto(){
        return GetOrderDto.builder()
                .products(products)
                .createdAt(createdAt)
                .totalAmount(totalAmount)
                .totalItems(totalItems)
                .transactionId(transactionId)
                .build();
    }

}
