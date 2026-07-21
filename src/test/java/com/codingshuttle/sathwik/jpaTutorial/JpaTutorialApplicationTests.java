package com.codingshuttle.sathwik.jpaTutorial;

import com.codingshuttle.sathwik.jpaTutorial.entites.ProductEntity;
import com.codingshuttle.sathwik.jpaTutorial.repositories.ProductRepository;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private ProductRepository productRepository;

	//this a way of using test to insert data
	@Test
	void saveProduct() {

		ProductEntity product = ProductEntity.builder()
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(200))
				.sku("CHOC001")
				.build();

		productRepository.save(product);
	}
}
