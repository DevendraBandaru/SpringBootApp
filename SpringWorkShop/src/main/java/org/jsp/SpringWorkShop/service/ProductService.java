package org.jsp.SpringWorkShop.service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringWorkShop.dao.ProductDao;
import org.jsp.SpringWorkShop.dto.Product;
import org.jsp.SpringWorkShop.dto.ResponceStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	public ResponceStructure<Product> saveProduct(Product product) {
		ResponceStructure<Product> structure = new ResponceStructure<Product>();
		structure.setMessage("Product registered successfully");
		structure.setBody(dao.saveProduct(product));
		structure.setCode(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponceStructure<Product> UpdateProduct(Product product) {
		ResponceStructure<Product> structure = new ResponceStructure<Product>();
		structure.setMessage("product updated successfully");
		structure.setBody(dao.saveProduct(product));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponceStructure<List<Product>> findAll() {
		ResponceStructure<List<Product>> structure = new ResponceStructure<>();
		structure.setBody(dao.findAll());
		structure.setMessage("all product are displayed");
		structure.setCode(HttpStatus.OK.value());
		return structure;
	}

	public ResponceStructure<Product> findProduct(int id) {
		ResponceStructure<Product> structure = new ResponceStructure<Product>();
		Optional<Product> recProduct = dao.findProduct(id);
		if (recProduct.isPresent()) {
			structure.setBody(recProduct.get());
			structure.setMessage("Product find");
			structure.setCode(HttpStatus.OK.value());
			return structure;
		}
		structure.setBody(null);
		structure.setMessage("Product not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}

	public ResponceStructure<String> deleteProduct(int id) {
		ResponceStructure<String> structure = new ResponceStructure<>();
		Optional<Product> recProduct = dao.findProduct(id);
		if (recProduct.isPresent()) {
			dao.deleteProduct(id);
			structure.setBody("product deleted");
			structure.setMessage("Product found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			return structure;
		}
		structure.setBody("product not deleted");
		structure.setMessage("product not fund");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}
}
