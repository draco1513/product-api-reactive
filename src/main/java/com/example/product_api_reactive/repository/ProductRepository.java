package com.example.product_api_reactive.repository;

import com.example.product_api_reactive.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface ProductRepository extends ReactiveCrudRepository<Product, UUID> {
    Flux<Product> findByStockLessThan(Integer stock);
}
