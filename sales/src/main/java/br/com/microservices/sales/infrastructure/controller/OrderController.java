package br.com.microservices.sales.infrastructure.controller;

import br.com.microservices.sales.application.useCases.CreateOrderUseCases;
import br.com.microservices.sales.domain.order.dto.CreateUpdadeOrderDto;
import br.com.microservices.sales.domain.order.dto.GetOrderDto;
import br.com.microservices.sales.domain.product.Product;
import br.com.microservices.sales.infrastructure.docs.OrderControllerDocs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/order-service"})
public class OrderController implements OrderControllerDocs {

    private final CreateOrderUseCases service;

    @PostMapping({"/criar"})
    public ResponseEntity<GetOrderDto> criarOrder(@RequestBody CreateUpdadeOrderDto dto) {
        var inserted = service.addOrder(dto);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }

}
