package br.com.microservice.payment.persistence.entity.basic;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter @SuperBuilder
@MappedSuperclass
public class BasicEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

}
