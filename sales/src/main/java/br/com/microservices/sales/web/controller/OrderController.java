package br.com.microservices.sales.web.controller;

import br.com.microservices.sales.application.service.OrderService;
import br.com.microservices.sales.web.request.CreateUpdadeOrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/order-service"})
public class OrderController {

    private final OrderService service;
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping({"/criar"})
    public ResponseEntity<?> createOrder(@RequestBody CreateUpdadeOrderDto orderDto) {
        var inserted = service.create(orderDto.getProducts());
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        var find = service.findAll();
        return new ResponseEntity<>(find, HttpStatus.OK);
    }

}
