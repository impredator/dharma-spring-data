package com.dharma.spring.dao;

import java.util.List;

import com.dharma.model.Product;

public interface ProductDAO {
	Product getProductById(Long id);

	List<Product> getAllProducts();

	boolean deleteProduct(Product product);

	boolean updateProduct(Product product);

	boolean createProduct(Product product);
}
