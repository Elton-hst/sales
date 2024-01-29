package br.com.microservices.orchestrator.persistence.entity;

import br.com.microservices.orchestrator.domain.entity.Event;
import br.com.microservices.orchestrator.persistence.entity.basic.BasicEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity extends BasicEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private OrderEntity payload;
    private String source;
    private String status;
    private LocalDateTime createdAt;

    public Event toEvent() {
        return new Event(
                getId(),
                payload.toOrder(),
                source,
                status,
                createdAt
        );
    }

}
