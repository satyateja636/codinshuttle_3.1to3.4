package com.codingshuttle.jpaTutorial.jpaTuts;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.Product;
import com.codingshuttle.jpaTutorial.jpaTuts.entities.repository.ProductRepository;

@SpringBootTest
class JpaTutsApplicationTests {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testRespository() {
		Product product = new Product();
		product.setSku("nestle234");
		product.setTitle("Nestle Chocolate");
		product.setPrice(BigDecimal.valueOf(123.45));
		product.setQuantity(12);
		
		Product savedProduct =productRepository.save(product);
		System.out.println(savedProduct);
	}
	
	@Test
	void testGetRepositories() {
		List<Product> entities = productRepository.findAll();
		System.out.println(entities);
	}
	
	@Test
	void testGetRepository() {
		List<Product> entities = productRepository.findByTitle("Nestle Chocolate");
		System.out.println(entities);
	}
	
	void testCreatedAtAfter() {
		List<Product> entities = productRepository.findByCreatedAtAfter(LocalDateTime.of(2024, 1, 1, 0, 0));
		System.out.println(entities);

	}
	
	void testfindByQunatityAndPRice() {
		List<Product> entities = productRepository.findByQuantityAndPrice(4, BigDecimal.valueOf(214.54));
		System.out.println(entities);

	}

	void testfindByQuantityGreaterThanAndPriceLessThan() {
		List<Product> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(4, BigDecimal.valueOf(214.54));
		System.out.println(entities);

	}
	
	void testfindByTitleLike() {
		List<Product> entities = productRepository.findByTitleLike("%Choco%");
		System.out.println(entities);

	}
	
	void testfindByTitleContaining() {
		List<Product> entities = productRepository.findByTitleContaining("Choco");
		System.out.println(entities);

	}
	
	void testfindByTitleContainingIgnoreCases() {
		List<Product> entities = productRepository.findByTitleContainingIgnoreCase("Choco");
		System.out.println(entities);

	}
	
	void testfindByTitleAndPrice() {
		Optional<Product> entity = productRepository.findByTitleAndPrice("Nestle Chocolate",BigDecimal.valueOf(123.45));
		entity.ifPresent(System.out::println);
	}
	
	void testfindByTitleAndPriceQueryMethod() {
		Optional<Product> entity = productRepository.findByTitleAndPriceQueryMethod("Nestle Chocolate",BigDecimal.valueOf(123.45));
		entity.ifPresent(System.out::println);
	}
}
