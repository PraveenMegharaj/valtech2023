package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface CustomerDAO {

	void deleteCustomer(int customerID);

	void updateCustomer(Customer customer);

	void createCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomer(int customerID);

	long countCustomer();

}