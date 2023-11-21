package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface CustomerOrdersDAO {

	void deleteCustomerOrders(int orderID);

	void updateCustomerOrders(CustomerOrders customerOrders);

	void createCustomerOrders(CustomerOrders customerOrders);

	List<CustomerOrders> getAllCustomerOrders();

	CustomerOrders getCustomerOrders(int orderID);

	long countCustomerOrders();

}