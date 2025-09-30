package com.example.product_api_reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductConvertedResponse {
    private UUID id;
    private String name;
    private Double priceUSD;
    private Double priceConverted;
    private String currency;
}
