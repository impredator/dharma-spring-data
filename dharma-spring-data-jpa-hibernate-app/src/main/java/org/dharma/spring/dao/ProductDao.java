package org.dharma.spring.dao;

import org.dharma.spring.jpa.ProductRepository;
import org.dharma.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDao {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(String name, Double price) {
        Product macpro = new Product();
        macpro.setName(name);
        macpro.setPrice(price);

        return repository.save(macpro);
    }

    public Product getProduct(int id) {
        return repository.findOne(id);
    }

    public Iterable<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product findProductByName(String productName) {
        return repository.findProductByName(productName);
    }

    public List<Product> findProductsByRange(double from, double to) {
        return repository.findByPriceBetween(from, to);
    }

    public long productCount() {
        return repository.count();
    }

    public void deleteProduct(Product product) {
        repository.delete(product);
    }

}
