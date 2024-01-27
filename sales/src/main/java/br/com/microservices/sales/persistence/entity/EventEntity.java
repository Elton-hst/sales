package br.com.microservices.sales.persistence.entity;

import br.com.microservices.sales.application.common.CommonEvent;
import br.com.microservices.sales.persistence.entity.basic.BasicEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter @Setter
@SuperBuilder
public class EventEntity extends BasicEntity {

    private String transactionId;
    private UUID orderId;
    @OneToOne(cascade = CascadeType.ALL)
    private OrderEntity payload;
    private String source;
    private String status;
    @OneToMany(cascade = CascadeType.ALL)
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
