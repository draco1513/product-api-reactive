package com.example.product_api_reactive.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ExchangeRateClient {
    private final WebClient webClient;

    public ExchangeRateClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.exchangerate.host").build();
    }

    public Mono<Double> getExchangeRate(String from, String to) {
        return webClient.get()
                .uri("/latest?base={from}&symbols={to}", from, to)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(json -> json.get("rates").get(to).asDouble());
    }
}
