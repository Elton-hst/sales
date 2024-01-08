package br.com.microservices.sales.infrastructure.message.consumer;

import br.com.microservices.sales.application.useCases.NotifyEndingUseCases;
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

    private final NotifyEndingUseCases notifyEnding;
    private final JsonUtil jsonUtil;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.notify-ending}"
    )
    public void consumeNotifyEndingEvent(String payload) {
        log.info("Receiving ending notification event {} from notify-ending topic", payload);
        var event = jsonUtil.toEvent(payload);
        notifyEnding.notifyEnding(event);
    }
}
