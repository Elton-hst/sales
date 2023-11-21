package br.com.microservices.sales.infrastructure.persistence.entity;

import br.com.microservices.sales.domain.orderProduct.OrderProduct;
import br.com.microservices.sales.domain.product.Product;
import br.com.microservices.sales.infrastructure.persistence.entity.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@Entity
@Table(name = "orderProduct")
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductEntity extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "quantity")
    private int quantity;

}
