package com.example.product_api_reactive.config;

import com.example.product_api_reactive.repository.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component

public class BufferSyncTask {
    private final ProductRepository productRepository;
    private final InMemoryProductRepository inMemoryRepo;

    public BufferSyncTask(ProductRepository productRepository,
                          InMemoryProductRepository inMemoryRepo) {
        this.productRepository = productRepository;
        this.inMemoryRepo = inMemoryRepo;
    }

    // cada 10 segundos intenta vaciar el buffer en la DB
    @Scheduled(fixedDelay = 10000)
    public void syncBufferToDatabase() {
        Flux.fromIterable(inMemoryRepo.getAll().values())
                .flatMap(productRepository::save)
                .doOnNext(saved -> inMemoryRepo.remove(saved.getId()))
                .subscribe(
                        success -> System.out.println("Synced product: " + success.getName()),
                        error -> System.err.println("Error syncing buffer: " + error.getMessage())
                );
    }
}
