package com.example.product_api_reactive;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ProductApiReactiveApplicationTests {

	@Test
	void contextLoads() {
	}

}
