package br.com.microservices.sales.infrastructure.message.consumer;

import br.com.microservices.sales.application.exception.EventException;
import br.com.microservices.sales.application.useCases.NotifyEndingUseCases;
import br.com.microservices.sales.web.response.GetEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component @Slf4j
@EnableKafka
@RequiredArgsConstructor
public class EventConsumer {

    private final NotifyEndingUseCases notifyEndingUseCases;

    @KafkaListener(
            groupId = "order-group",
            topics = "start-saga",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeNotifyEndingEvent(GetEventDto payload) {
        try {
            notifyEndingUseCases.notifyEnding(payload);
        } catch (EventException e){
            throw new EventException(e.getMessage());
        }
    }
}
