package br.com.microservices.sales.web.controller;

import br.com.microservices.sales.application.service.ProductService;
import br.com.microservices.sales.domain.common.CommonProduct;
import br.com.microservices.sales.domain.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/Product"})
public class ProductController {

    private final ProductService service;

    @PostMapping({"/criar"})
    public ResponseEntity<?> createProduct(@RequestBody List<CommonProduct> products) {
        var inserted = service.create(products);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }

}
