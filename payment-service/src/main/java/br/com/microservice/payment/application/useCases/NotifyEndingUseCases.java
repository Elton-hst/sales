package br.com.microservice.payment.application.useCases;

import br.com.microservice.payment.web.response.GetEventDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotifyEndingUseCases {
    public void notifyEnding(GetEventDto event) {
        GetEventDto newEvent = new GetEventDto(
                event.order(),
                event.source(),
                event.source(),
                event.createdAt()
        );
        log.info("Evendo recebido {}", newEvent);
    }

}
