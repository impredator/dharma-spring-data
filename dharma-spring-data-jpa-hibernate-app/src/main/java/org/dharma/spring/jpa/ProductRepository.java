package org.dharma.spring.jpa;

import org.dharma.spring.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    Product findProductByName(String name);

    List<Product> findByPriceBetween(double from, double to);
}