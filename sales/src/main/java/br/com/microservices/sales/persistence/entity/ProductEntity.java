package br.com.microservices.sales.persistence.entity;

import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.persistence.entity.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name = "PRODUCT_ENTITY")
@Getter @Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BasicEntity{

    private String code;
    private double unitValue;

    public CommonProduct toProduct() {
        return CommonProduct.builder()
                .id(getId())
                .code(code)
                .unitValue(unitValue)
                .build();
    }

}
