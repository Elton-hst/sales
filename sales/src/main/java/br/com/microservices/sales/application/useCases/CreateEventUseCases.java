package br.com.microservices.sales.application.useCases;

import br.com.microservices.sales.application.exception.EventException;
import br.com.microservices.sales.domain.common.CommonEvent;
import br.com.microservices.sales.domain.common.CommonOrder;
import br.com.microservices.sales.domain.entity.Event;
import br.com.microservices.sales.domain.repository.EventRepository;
import br.com.microservices.sales.infrastructure.message.producer.SagaProducer;
import br.com.microservices.sales.infrastructure.utils.JsonUtil;

import java.time.LocalDateTime;

public class CreateEventUseCases {

    private final EventRepository repository;
    private final SagaProducer producer;
    private final JsonUtil jsonUtil;
    public CreateEventUseCases(EventRepository repository, SagaProducer producer, JsonUtil jsonUtil) {
        this.repository = repository;
        this.producer = producer;
        this.jsonUtil = jsonUtil;
    }

    public CommonEvent create(CommonOrder order) {
        CommonEvent event = CommonEvent.builder()
                .orderId(order.getId())
                .payload(order)
                .transactionId(order.getTransactionId())
                .createdAt(LocalDateTime.now())
                .build();

        sendEvent(order);

        return add(event);
    }

    private void sendEvent(CommonOrder order) {
        producer.sendEvent(jsonUtil.toJson(order));
    }

    private CommonEvent add(CommonEvent event) {
        return repository.add(event)
                .orElseThrow(() -> new EventException("Erro ao tentar criar um evento"));
    }

}
