package br.com.microservices.sales.infrastructure.persistence.entity;

import br.com.microservices.sales.domain.product.Product;
import br.com.microservices.sales.infrastructure.persistence.entity.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@Entity
@SuperBuilder
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BasicEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "unitValue")
    private double unitValue;

}
