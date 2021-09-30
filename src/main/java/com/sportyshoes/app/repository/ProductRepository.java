package com.sportyshoes.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.sportyshoes.app.model.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{

	
	Optional<Product> findBySeason(String season);

	Optional<Product> findByBrand(String brand);

	Optional<Product> findByColor(String color);

	Optional<Product> findByPrice(int price);

	


}

