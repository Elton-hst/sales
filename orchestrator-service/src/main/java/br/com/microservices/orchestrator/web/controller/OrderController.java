package br.com.microservices.orchestrator.web.controller;

import br.com.microservices.orchestrator.application.facede.OrderFacede;
import br.com.microservices.orchestrator.domain.repository.OrderRepository;
import br.com.microservices.orchestrator.web.request.CreateUpdateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping({"/order-service"})
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacede useCase;
    private final OrderRepository orderRepository;

    @PostMapping({"/criar"})
    public ResponseEntity<?> createOrder(@RequestBody Set<CreateUpdateProductDto> productDtos) {
        var event = useCase.createOrder(productDtos);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @GetMapping({"/buscarOrder/{userId}"})
    public ResponseEntity<?> buscarOrder(@PathVariable UUID userId) {
        var user = orderRepository.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
