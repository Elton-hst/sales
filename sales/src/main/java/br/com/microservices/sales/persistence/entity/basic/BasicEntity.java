package br.com.microservices.sales.persistence.entity.basic;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@SuperBuilder
@MappedSuperclass
public class BasicEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

}
