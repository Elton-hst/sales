package br.com.microservices.sales.infrastructure.persistence.entity;

import br.com.microservices.sales.infrastructure.persistence.entity.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@ToString @Getter
@SuperBuilder
@Entity(name = "ORDER_ENTITY")
@Table(name = "ORDER_ENTITY")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity extends BasicEntity {

    @OneToMany(mappedBy = "order")
    private List<OrderProductEntity> products;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "totalAmount")
    private double totalAmount;

    @Column(name = "totalItems")
    private int totalItems;

}

