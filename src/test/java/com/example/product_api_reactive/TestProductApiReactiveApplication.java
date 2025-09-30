package com.example.product_api_reactive;

import org.springframework.boot.SpringApplication;

public class TestProductApiReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductApiReactiveApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
