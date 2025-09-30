package com.example.product_api_reactive.controller;

import com.example.product_api_reactive.dto.ProductConvertedResponse;
import com.example.product_api_reactive.dto.ProductRequest;
import com.example.product_api_reactive.model.Product;
import com.example.product_api_reactive.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<Product> create(@RequestBody ProductRequest request) {
        return service.createProduct(request);
    }

    @GetMapping
    public Flux<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable UUID id, @RequestBody ProductRequest request) {
        return service.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable UUID id) {
        return service.deleteProduct(id);
    }
    @GetMapping("/debug/all")
    public Flux<Product> debugAll() {
        return service.getAllProducts();
    }

    @GetMapping("/converted/{currency}")
    public Flux<ProductConvertedResponse> getConverted(@PathVariable String currency) {
        return service.getProductsConverted(currency);
    }
}
