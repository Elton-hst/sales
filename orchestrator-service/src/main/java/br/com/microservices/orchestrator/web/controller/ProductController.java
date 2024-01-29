package br.com.microservices.orchestrator.web.controller;

import br.com.microservices.orchestrator.application.facede.ProductFacede;
import br.com.microservices.orchestrator.web.request.CreateUpdateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/Product"})
public class ProductController {

    private final ProductFacede useCase;

    @PostMapping({"/criar"})
    public ResponseEntity<?> createProduct(@RequestBody Set<CreateUpdateProductDto> products) {
        var inserted = useCase.createProduct(products);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }

}
