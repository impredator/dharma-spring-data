package org.dharma.spring.main;

import java.util.List;

import org.dharma.spring.jpa.ProductRepository;
import org.dharma.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringJpaApp {
    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringJpaApp samb = (SpringJpaApp) context.getBean("mainClass");

        System.out.println("=====================================");
        System.out.println("Before adding products" + samb.productCount());
        Product addedProduct = samb.addProduct();
        System.out.println("After adding products" + samb.productCount());

        System.out.println("=====================================");
        Product productRead = samb.getProduct(3);
        System.out.println("Getting product with ID 3::" + productRead);

        System.out.println("=====================================");
        System.out.println("Getting all Products");
        Iterable<Product> productList = samb.getAllProducts();
        productList.forEach(c -> System.out.println(c));

        System.out.println("=====================================");
        System.out.println("Finding productName iPhoneX");
        Product product = samb.findProductByName("iPhoneX");
        System.out.println(product);

        System.out.println("=====================================");
        System.out.println("Finding All Products which price from 5000 to 10000");
        List<Product> products = samb.findProductsByRange(5000.0, 10000.0);
        System.out.println(products);

        System.out.println("=====================================");
        System.out.println("Before deleting products" + samb.productCount());
        samb.deleteProduct(addedProduct);
        System.out.println("After deleting products" + samb.productCount());

        System.out.println("=====================================");
        System.out.println("We are done with all operations");
    }

    private Product addProduct() {
        // Add Product object to database
        Product macpro = new Product();
        macpro.setName("Mac Pro");
        macpro.setPrice(15999.0);

        return repository.save(macpro);
    }

    private Product getProduct(int id) {
        return repository.findOne(id);
    }

    private Iterable<Product> getAllProducts() {
        return repository.findAll();
    }

    private Product findProductByName(String productName) {
        return repository.findProductByName(productName);
    }

    private List<Product> findProductsByRange(double from, double to) {
        return repository.findByPriceBetween(from, to);
    }

    private long productCount() {
        return repository.count();
    }

    private void deleteProduct(Product product) {
        repository.delete(product);
    }

}
