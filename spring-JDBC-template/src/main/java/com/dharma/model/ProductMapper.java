package com.dharma.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet resultSet, int i) throws SQLException {

		Product product = new Product();
		product.setId(resultSet.getLong("id"));
		product.setName(resultSet.getString("name"));
		product.setPrice(resultSet.getDouble("price"));
		return product;
	}
}
