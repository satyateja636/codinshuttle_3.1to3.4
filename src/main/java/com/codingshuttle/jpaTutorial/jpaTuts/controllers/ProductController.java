package com.codingshuttle.jpaTutorial.jpaTuts.controllers;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.Product;
import com.codingshuttle.jpaTutorial.jpaTuts.entities.repository.ProductRepository;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

	private final ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
//	@GetMapping
//	public List<Product> getAllProducts(){
//		return productRepository.findByOrderByPrice();
//	}
	
//	@GetMapping
//	public List<Product> getAllProductsUsingFindBy(@RequestParam(defaultValue = "id") String sortBy){
//		return productRepository.findBy(Sort.by(sortBy));
//	}
	
	
	
	//NOTE -- take care of the commented code as well
//	@GetMapping
//	public List<Product> getAllProductsUsingFindBy(@RequestParam(defaultValue = "id") String sortBy){
////		return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price")); -- this is another way
//		return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));
//	}
	
	//pagination example
	
	private final int PAGE_SIZE = 5;
//	@GetMapping
//	public Page<Product> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
//			@RequestParam(defaultValue = "1") Integer pageNumber){
//		Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));
//		return productRepository.findAll(pageable);
//	}
	
	
	@GetMapping
	public List<Product> getAllProducts(
			@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "1") Integer pageNumber){
		Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));
		return productRepository.findByTitleContainingIgnoreCase(title, pageable);
	}
}
