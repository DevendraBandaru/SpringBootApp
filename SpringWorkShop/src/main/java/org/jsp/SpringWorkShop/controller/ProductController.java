package org.jsp.SpringWorkShop.controller;

import java.util.List;

import org.jsp.SpringWorkShop.dto.Product;
import org.jsp.SpringWorkShop.dto.ResponceStructure;
import org.jsp.SpringWorkShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("/products")
	public ResponceStructure<Product> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	@PutMapping("/products")
	public ResponceStructure<Product> updateProduct(@RequestBody Product product) {
		return service.UpdateProduct(product);
	}
	@GetMapping("products/{id}")
	public ResponceStructure<Product> findProduct(@PathVariable int id) {
		return service.findProduct(id);
	}
	@GetMapping("/products")
	public ResponceStructure<List<Product>> findAll(){
		return service.findAll();
	}
	@DeleteMapping("/products/{id}")
	public ResponceStructure<String> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
