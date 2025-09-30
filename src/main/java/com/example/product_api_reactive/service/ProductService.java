package com.example.product_api_reactive.service;


import com.example.product_api_reactive.client.ExchangeRateClient;
import com.example.product_api_reactive.config.InMemoryProductRepository;
import com.example.product_api_reactive.dto.ProductConvertedResponse;
import com.example.product_api_reactive.dto.ProductRequest;
import com.example.product_api_reactive.model.Product;
import com.example.product_api_reactive.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductService     {
    private final ProductRepository repository;
    private final ExchangeRateClient exchangeRateClient;
    private final InMemoryProductRepository inMemoryRepo;



    public Mono<Product> saveProduct(Product product) {
        // Primero guardar en memoria
        inMemoryRepo.save(product);

        // Intentar guardar en la DB
        return repository.save(product)
                .doOnSuccess(saved -> inMemoryRepo.remove(product.getId())) // si se guarda bien, limpiar buffer
                .onErrorResume(ex -> {
                    // Si falla la DB, mantener en memoria
                    System.err.println("DB error, manteniendo en buffer: " + ex.getMessage());
                    return Mono.just(product);
                });
    }

    public ProductService(ProductRepository repository, ExchangeRateClient exchangeRateClient, InMemoryProductRepository inMemoryRepo) {
        this.repository = repository;
        this.exchangeRateClient = exchangeRateClient;
        this.inMemoryRepo = inMemoryRepo;
    }

    public Mono<Product> createProduct(ProductRequest request) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return repository.save(product);
    }

    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    public Mono<Product> getProductById(UUID id) {
        return repository.findById(id);
    }

    public Mono<Product> updateProduct(UUID id, ProductRequest request) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setName(request.getName());
                    existing.setDescription(request.getDescription());
                    existing.setPrice(request.getPrice());
                    existing.setStock(request.getStock());
                    return repository.save(existing);
                });
    }

    public Mono<Void> deleteProduct(UUID id) {
        return repository.deleteById(id);
    }

    public Flux<ProductConvertedResponse> getProductsConverted(String currency) {
        return exchangeRateClient.getExchangeRate("USD", currency)
                .flatMapMany(rate -> repository.findAll()
                        .map(p -> new ProductConvertedResponse(
                                p.getId(),
                                p.getName(),
                                p.getPrice(),
                                p.getPrice() * rate,
                                currency
                        ))

                );
    }
}
