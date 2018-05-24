package com.dharma.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dharma.model.Product;
import com.dharma.model.ProductMapper;

@Component
public class ProductDAOImpl implements ProductDAO {

	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_PRODUCT = "select * from product where id = ?";
	private final String SQL_DELETE_PRODUCT = "delete from product where id = ?";
	private final String SQL_UPDATE_PRODUCT = "update product set price = ?, name = ? where id = ?";
	private final String SQL_GET_ALL = "select * from product";
	private final String SQL_INSERT_PRODUCT = "insert into product(id, price, name) values(?,?,?)";

	@Autowired
	public ProductDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Product getProductById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PRODUCT, new Object[] { id }, new ProductMapper());
	}

	public List<Product> getAllProducts() {
		return jdbcTemplate.query(SQL_GET_ALL, new ProductMapper());
	}

	public boolean deleteProduct(Product product) {
		return jdbcTemplate.update(SQL_DELETE_PRODUCT, product.getId()) > 0;
	}

	public boolean updateProduct(Product product) {
		return jdbcTemplate.update(SQL_UPDATE_PRODUCT, product.getPrice(), product.getName(),
				product.getId()) > 0;
	}

	public boolean createProduct(Product product) {
		return jdbcTemplate.update(SQL_INSERT_PRODUCT, product.getId(), product.getPrice(), product.getName()) > 0;
	}
}
