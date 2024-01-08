package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.domain.common.CommonEvent;
import br.com.microservices.sales.domain.entity.Event;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class NotifyEndingUseCases {

    private final CreateEventUseCases createEvent;
    public NotifyEndingUseCases(CreateEventUseCases createEvent) {
        this.createEvent = createEvent;
    }

    public void notifyEnding(Event event) {
        CommonEvent newEvent = CommonEvent.builder()
                .orderId(event.getOrderId())
                .createdAt(LocalDateTime.now())
                .build();

        createEvent.create(newEvent.getPayload());

        log.info("Order {} with saga notified! TransactionId: {}", event.getOrderId(), event.getTransactionId());
    }

}
