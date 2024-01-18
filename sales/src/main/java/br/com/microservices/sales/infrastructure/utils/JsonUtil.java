package br.com.microservices.sales.infrastructure.utils;

import br.com.microservices.sales.application.exception.EventException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            return "";
        }
    }

    public Object toEvent(String json) {
        try {
            return objectMapper.readValue(json, Object.class);
        } catch (EventException | JsonProcessingException e) {
            throw new EventException("erro ao converter o evento");
        }
    }
}