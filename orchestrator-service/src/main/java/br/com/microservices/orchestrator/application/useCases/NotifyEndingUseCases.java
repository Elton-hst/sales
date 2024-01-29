package br.com.microservices.orchestrator.application.useCases;

import br.com.microservices.orchestrator.web.response.GetEventDto;
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
