package br.com.microservices.sales.web.controller;

import br.com.microservices.sales.application.common.CommonProduct;
import br.com.microservices.sales.application.facede.OrderFacede;
import br.com.microservices.sales.domain.entity.Product;
import br.com.microservices.sales.domain.repository.OrderRepository;
import br.com.microservices.sales.infrastructure.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping({"/order-service"})
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacede useCase;
    private final JsonUtil jsonUtil;
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping({"/criar"})
    public ResponseEntity<?> createOrder() {
        Set<Product> products = new HashSet<>();
        var product = CommonProduct.builder().code("camisa").unitValue(20).build();
        products.add(product);
        var order = useCase.createOrder(products);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping({"/buscarOrder/{userId}"})
    public ResponseEntity<?> buscarOrder(@PathVariable UUID userId) {
        var user = orderRepository.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public void test() {
        kafkaTemplate.send("start-saga", "test");
    }

}
