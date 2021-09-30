package com.sportyshoes.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.app.model.Product;

import com.sportyshoes.app.repository.ProductRepository;





@RestController
@RequestMapping("products")
public class ProductController {
	
	 @Autowired
	ProductRepository productrepository;
	
	
	
	// retrieve all product from database
	@GetMapping("all")
	public List<Product> getAllProduct()
	{
		List<Product> product=(List<Product>) productrepository.findAll(); 
		return product;
	}
	
	// insert new product into database
	@PostMapping("add")
	public Product addProduct(@RequestBody Product product)
	{
		return productrepository.save(product);
	}
	
	// search particular product by their ID
	@GetMapping("product/id/{id}")
	public Optional<Product> getProductId(@PathVariable int id)
	{
		return productrepository.findById(id);
	}
	
	// search particular product by their season
			@GetMapping("product/season/{season}")
			public Optional<Product> getProductSeason(@PathVariable String season)
			{
				return productrepository.findBySeason(season);
			}
	// search particular product by their brand
				@GetMapping("product/brand/{brand}")
				public Optional<Product> getProductBrand(@PathVariable String brand)
				{
					return productrepository.findByBrand(brand);
				}
	// search particular product by their color
				@GetMapping("product/color/{color}")
				public Optional<Product> getProductColor(@PathVariable String color)
				{
					return productrepository.findByColor(color);
				}
	// search particular product by their price
				@GetMapping("product/price/{price}")
				public Optional<Product> getProductPrice(@PathVariable int price)
				{
					return productrepository.findByPrice(price);
				}
	// update existing product
	@PutMapping("update/{id}")
	public Product updateProduct(@RequestBody Product product)
	{
		return productrepository.save(product);
	}
	
	
	
	// delete particular product from database
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		productrepository.deleteById(id);
	}
	
	
	
	
	
	
}


