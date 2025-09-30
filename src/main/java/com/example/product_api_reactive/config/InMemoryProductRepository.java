package com.example.product_api_reactive.config;

import com.example.product_api_reactive.model.Product;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryProductRepository  {
    private final Map<UUID, Product> buffer = new ConcurrentHashMap<>();

    public void save(Product product) {
        buffer.put(product.getId(), product);
    }

    public Map<UUID, Product> getAll() {
        return buffer;
    }

    public void remove(UUID id) {
        buffer.remove(id);
    }
}
