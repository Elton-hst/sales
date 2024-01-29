package br.com.microservices.orchestrator.persistence.entity;

import br.com.microservices.orchestrator.domain.entity.Product;
import br.com.microservices.orchestrator.persistence.entity.basic.BasicEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "PRODUCT_ENTITY")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BasicEntity{

    private String code;
    private double unitValue;

    public Product toProduct() {
        return new Product(
                getId(),
                code,
                unitValue
        );
    }

}
