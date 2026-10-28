package com.codingshuttle.jpaTutorial.jpaTuts.entities.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByTitle(String title);
	
	List<Product> findByCreatedAtAfter(LocalDateTime after);
	
	List<Product> findByQuantityAndPrice(Integer quantity, BigDecimal price);
	
	List<Product> findByQuantityGreaterThanAndPriceLessThan(Integer quantity, BigDecimal price);
	
	List<Product> findByTitleLike(String title);
	
	List<Product> findByTitleContaining(String title);
	
	List<Product> findByTitleContainingIgnoreCase(String title);
	
	//only @UniqueConstraints declared values only will be used for creating this method, we done for these two columns in the product entity class
	Optional<Product> findByTitleAndPrice(String title, BigDecimal price);
	
	@Query("SELECT p FROM Product p WHERE p.title = ?1 AND p.price = ?2")
	Optional<Product> findByTitleAndPriceQueryMethod(String title, BigDecimal price);
	
	
	List<Product> findByTitleOrderByPrice(String title);
	
	List<Product> findByOrderByPrice();
	
	List<Product> findBy(Sort sort);
	
	List<Product> findByTitleContainingIgnoreCase(String title, Pageable pageable);

}
