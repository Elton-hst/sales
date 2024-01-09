package br.com.microservices.controller;

import br.com.microservices.model.product.Product;
import br.com.microservices.repository.ProductRepository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/criar")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        var newProduct = productRepository.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = this.productRepository.findAll();
        return ResponseEntity.ok(productList);
    }

    @DeleteMapping("/bucar/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public void delete(@PathVariable String id){
        this.productRepository.deleteById(id);
    }

}
