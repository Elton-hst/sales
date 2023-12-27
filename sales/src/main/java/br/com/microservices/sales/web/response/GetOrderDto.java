package br.com.microservices.sales.web.response;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder @Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderDto {

    private UUID id;
    private List<CommonProduct> products;
    private int quantity;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

}
