package br.com.microservices.sales.infrastructure.message.producer;

import br.com.microservices.sales.application.exception.EventException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SagaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.start-saga}")
    private String sagaTopic;

    public void sendEvent(String order) {
        try {
            kafkaTemplate.send(sagaTopic, order);
        } catch (EventException e) {
            throw new EventException("Erro ao tentar enviar o evento");
        }
    }

}
