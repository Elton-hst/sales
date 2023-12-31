package br.com.microservices.sales.persistence.entity;

import br.com.microservices.sales.domain.common.CommonEvent;
import br.com.microservices.sales.domain.common.CommonHistory;
import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.persistence.entity.basic.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter @Setter
@SuperBuilder
@NoArgsConstructor
public class EventEntity extends BasicEntity {

    private String transactionId;
    private UUID orderId;
    @OneToOne
    private OrderEntity payload;
    private String source;
    private String status;
    @OneToMany
    private List<HistoryEntity> eventHistory;
    private LocalDateTime createdAt;

    public CommonEvent toEvent() {
        return CommonEvent.builder()
                .id(getId())
                .orderId(orderId)
                .payload(payload.toOrder())
                .source(source)
                .status(status)
                .eventHistory(eventHistory
                        .stream()
                        .map(HistoryEntity::toHistory)
                        .collect(Collectors.toList()))
                .createdAt(createdAt)
                .build();
    }

}
