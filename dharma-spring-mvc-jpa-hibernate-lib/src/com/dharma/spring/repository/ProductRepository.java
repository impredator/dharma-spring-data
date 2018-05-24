package com.dharma.spring.repository;

import com.dharma.spring.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository<P> extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
