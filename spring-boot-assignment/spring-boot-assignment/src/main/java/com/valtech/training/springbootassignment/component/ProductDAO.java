package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface ProductDAO {

	void deleteProduct(int productID);

	void updateProduct(Product product);

	void createProduct(Product product);

	List<Product> getAllProducts();


	long countProducts();

	Product getProduct(int productID);

}