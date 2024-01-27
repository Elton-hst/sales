package br.com.microservices.sales.infrastructure.message.consumer;

import br.com.microservices.sales.application.common.CommonOrder;
import br.com.microservices.sales.application.exception.EventException;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.infrastructure.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableKafka
@RequiredArgsConstructor
public class EventConsumer {

    private final JsonUtil jsonUtil;
    private final OrderRepository repository;

    @KafkaListener(
            groupId = "order-group",
            topics = "start-saga"
    )
    public void consumeNotifyEndingEvent(String payload) {
        try {
            log.info("cosumer: {}", payload);
            var result = (CommonOrder) jsonUtil.toEvent(payload);
            repository.add(result);
        } catch (EventException e){
            throw new EventException("erro ao tentar consumir o evento");
        }
    }
}
