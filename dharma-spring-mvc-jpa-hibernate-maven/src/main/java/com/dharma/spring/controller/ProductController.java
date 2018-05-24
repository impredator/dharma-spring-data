package com.dharma.spring.controller;

import java.util.List;

import com.dharma.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dharma.spring.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
    String welcome() {
		return "Welcome to Dharma Mall";
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public @ResponseBody
    Product getProduct(@PathVariable Long id) {
		return productService.getById(id);
	}

	@RequestMapping(value = "/productByName/{name}", method = RequestMethod.GET)
	public List<Product> getProductByName(@PathVariable String name) {
		return productService.findByName(name);
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public @ResponseBody
	List<Product> getAll() {
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public HttpStatus insertProduct(@RequestBody Product product) {
		return productService.addProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public HttpStatus updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
