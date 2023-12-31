package br.com.microservices.sales.web.controller;

import br.com.microservices.sales.application.service.OrderService;
import br.com.microservices.sales.web.request.CreateUpdadeOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/order-service"})
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping({"/criar"})
    public ResponseEntity<?> createOrder(@RequestBody CreateUpdadeOrderDto orderDto) {
        var inserted = service.create(orderDto.getProducts());
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }

}
