package com.dharma;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dharma.model.Product;
import com.dharma.spring.config.AppConfig;
import com.dharma.spring.dao.ProductDAO;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductDAO productDAO = context.getBean(ProductDAO.class);

		System.out.println("List of product is:");

		for (Product p : productDAO.getAllProducts()) {
			System.out.println(p);
		}

		System.out.println("\nGet product with ID 2");

		Product productById = productDAO.getProductById(2L);
		System.out.println(productById);

		System.out.println("\nCreating product: ");
		Product product = new Product(24L, 9999.0, "TNT");
		System.out.println(product);
		productDAO.createProduct(product);
		System.out.println("\nList of product is:");

		for (Product p : productDAO.getAllProducts()) {
			System.out.println(p);
		}

		System.out.println("\nDeleting product with ID 2");
		productDAO.deleteProduct(productById);

		System.out.println("\nUpdate product with ID 24");

		Product pproduct = productDAO.getProductById(24L);
		pproduct.setName("Smartian TNT");
		productDAO.updateProduct(pproduct);

		System.out.println("\nList of product is:");
		for (Product p : productDAO.getAllProducts()) {
			System.out.println(p);
		}

		context.close();
	}
}
