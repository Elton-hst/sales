package br.com.microservices.sales.persistence.entity;

import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.persistence.entity.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "ORDER_ENTITY")
@Table(name = "ORDER_ENTITY")
@Getter @Setter
@SuperBuilder
@NoArgsConstructor
public class OrderEntity extends BasicEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductEntity> products;
    private int quantity;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

    public CommonOrder toOrder() {
        return CommonOrder.builder()
                .id(getId())
                .products(products.stream()
                        .map(ProductEntity::toProduct)
                        .collect(Collectors.toList()))
                .quantity(quantity)
                .createdAt(createdAt)
                .transactionId(transactionId)
                .totalAmount(totalAmount)
                .totalItems(totalItems)
                .build();
    }

}

