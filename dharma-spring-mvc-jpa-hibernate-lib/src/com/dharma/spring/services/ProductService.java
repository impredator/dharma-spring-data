package com.dharma.spring.services;

import java.util.List;

import com.dharma.spring.model.Product;
import com.dharma.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

	@Autowired
    ProductRepository<Product> productRepository;

	@Transactional
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Transactional
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Transactional
	public Product getById(Long id) {
		return productRepository.findOne(id);
	}

	@Transactional
	public void deleteProduct(Long productId) {
		productRepository.delete(productId);
	}

	@Transactional
	public boolean addProduct(Product product) {
		return productRepository.save(product) != null;
	}

	@Transactional
	public boolean updateProduct(Product product) {
		return productRepository.save(product) != null;
	}

	@Transactional
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}
}
