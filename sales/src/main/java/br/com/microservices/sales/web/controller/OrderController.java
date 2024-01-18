package br.com.microservices.sales.web.controller;

import br.com.microservices.sales.application.service.OrderService;
import br.com.microservices.sales.infrastructure.utils.JsonUtil;
import br.com.microservices.sales.web.request.CreateUpdadeOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/order-service"})
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final JsonUtil jsonUtil;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping({"/criar"})
    public ResponseEntity<?> createOrder(@RequestBody CreateUpdadeOrderDto orderDto) {
        var inserted = service.create(orderDto.getProducts());
        kafkaTemplate.send("start-saga", jsonUtil.toJson(inserted));
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }

    @GetMapping
    public void test() {
        kafkaTemplate.send("start-saga", "test");
    }

}
