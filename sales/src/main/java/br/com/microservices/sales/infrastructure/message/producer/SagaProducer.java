package br.com.microservices.sales.infrastructure.message.producer;

import br.com.microservices.sales.application.exception.EventException;
import br.com.microservices.sales.web.response.GetEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component @Slf4j
@RequiredArgsConstructor
public class SagaProducer {

    private final KafkaTemplate<String, GetEventDto> kafkaTemplate;

    public void sendEvent(GetEventDto order) {
        try {
            log.info("Enviando evento para o Order: {}", order);
            kafkaTemplate.send("start-saga", order);
        } catch (EventException e) {
            log.error("Error trying to send data {}", order);
            throw new EventException("Erro ao tentar enviar o evento");
        }
    }

}
