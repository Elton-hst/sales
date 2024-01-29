package br.com.microservice.payment.persistence.entity;

import br.com.microservice.payment.domain.entity.Order;
import br.com.microservice.payment.persistence.entity.basic.BasicEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "ORDER_ENTITY")
@SuperBuilder @Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BasicEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductEntity> products;
    private int quantity;
    private LocalDateTime createdAt;
    private String transactionId;
    private double totalAmount;
    private int totalItems;

    public Order toOrder() {
        return new Order(
                getId(),
                products.stream()
                        .map(ProductEntity::toProduct)
                        .collect(Collectors.toSet()),
                quantity,
                createdAt,
                transactionId,
                totalAmount,
                totalItems);
    }

}

