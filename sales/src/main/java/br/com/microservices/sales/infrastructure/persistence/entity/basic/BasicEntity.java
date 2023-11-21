package br.com.microservices.sales.infrastructure.persistence.entity.basic;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString @Getter
@SuperBuilder
@MappedSuperclass
public class BasicEntity {

    @Id
    protected String id;
}
