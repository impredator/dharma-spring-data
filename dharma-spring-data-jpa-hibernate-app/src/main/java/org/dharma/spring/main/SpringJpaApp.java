package org.dharma.spring.main;

import java.util.List;

import org.dharma.spring.dao.ProductDao;
import org.dharma.spring.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJpaApp {

    private static ProductDao dao;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = (ProductDao) context.getBean("productDao");

        Product addedProduct = addProduct("Mac Pro", 15999.9);

        getAllProducts();

        getProductByName("iPhoneX");

        getProductsRangeBetween(5000.0, 10000.0);

        deleteProductBy(addedProduct);

        done();
    }

    private static Product addProduct(String name, Double price) {
        System.out.println("=====================================");
        System.out.println("Before adding products" + dao.productCount());
        Product addedProduct = dao.addProduct(name, price);
        System.out.println("After adding products" + dao.productCount());

        return addedProduct;
    }

    private static void getAllProducts() {
        System.out.println("=====================================");
        System.out.println("Getting all Products");
        Iterable<Product> productList = dao.getAllProducts();
        productList.forEach(c -> System.out.println(c));
    }

    private static void getProductByName(String name) {
        System.out.println("=====================================");
        System.out.println("Finding productName " + name);
        Product product = dao.findProductByName(name);
        System.out.println(product);
    }

    private static void getProductsRangeBetween(Double from, Double to) {
        System.out.println("=====================================");
        System.out.println("Finding All Products which price from " + from + " to " + to);
        List<Product> products = dao.findProductsByRange(from, to);
        System.out.println(products);
    }

    private static void deleteProductBy(Product product) {
        System.out.println("=====================================");
        System.out.println("Before deleting products" + dao.productCount());
        dao.deleteProduct(product);
        System.out.println("After deleting products" + dao.productCount());
    }

    private static void done() {
        System.out.println("=====================================");
        System.out.println("We are done with all operations");
    }

}
