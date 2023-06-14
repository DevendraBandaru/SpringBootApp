package org.jsp.SpringWorkShop.repository;

import org.jsp.SpringWorkShop.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
