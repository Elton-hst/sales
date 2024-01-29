package br.com.microservice.payment.application.useCases;

import br.com.microservice.payment.application.exception.EventException;
import br.com.microservice.payment.domain.entity.Event;
import br.com.microservice.payment.domain.repository.EventRepository;
import br.com.microservice.payment.infrastructure.message.producer.SagaProducer;
import br.com.microservice.payment.web.request.CreateUpdateEventDto;
import br.com.microservice.payment.web.response.GetEventDto;

import java.time.LocalDateTime;

public class CreateEventUseCases {

    private final EventRepository repository;
    private final SagaProducer producer;
    public CreateEventUseCases(EventRepository repository, SagaProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    public GetEventDto create(CreateUpdateEventDto eventDto) {
        var event = new Event(
                eventDto.order(),
                "Seila",
                "ATIVO",
                LocalDateTime.now()
        );
        var newEvent = add(event).toEventDto();
        producer.sendEvent(newEvent);
        return newEvent;
    }

    private Event add(Event event) {
        return repository.add(event)
                .orElseThrow(() -> new EventException("Erro ao tentar criar um evento"));
    }

}
