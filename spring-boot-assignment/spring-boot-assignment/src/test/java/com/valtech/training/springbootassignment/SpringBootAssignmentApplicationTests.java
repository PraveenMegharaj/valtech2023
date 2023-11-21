package com.valtech.training.springbootassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.springbootassignment.component.Company;
import com.valtech.training.springbootassignment.component.CompanyDAO;
import com.valtech.training.springbootassignment.component.Customer;
import com.valtech.training.springbootassignment.component.CustomerDAO;
import com.valtech.training.springbootassignment.component.CustomerOrders;
import com.valtech.training.springbootassignment.component.CustomerOrdersDAO;
import com.valtech.training.springbootassignment.component.HelloWorld;
import com.valtech.training.springbootassignment.component.Product;
import com.valtech.training.springbootassignment.component.ProductDAO;
import com.valtech.training.springbootassignment.service.EmployeeService;

@SpringBootTest
class SpringBootAssignmentApplicationTests {

//	@Autowired
//	private HelloController hello;
//			
//	@Test
//	void contextLoads() {
//		assertEquals("Hello", hello.hello());
//	}
//	
//	@Autowired
//	private CompanyDAO company;
//	
//	@Test
//	void companyTest() {
//		company.createCompany(new Company("Valtech","Bangalore"));
//	}
//	
//	@Autowired
//	private ProductDAO p;
//	
//	@Test
//	void productTest() {
//		p.createProduct(new Product("Bag",10000,1));
//	}
	
//	@Autowired
//	private CustomerDAO cus;
//	
//	@Test
//	void customerTest() {
//		cus.createCustomer(new Customer("Praveen","375788","Bangalore"));
//	}
//	
//	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//	@Autowired
//	private CustomerOrdersDAO co;
//	
//	@Test
//	void ordersTest() throws ParseException {
//		co.createCustomerOrders(new CustomerOrders(1, df.parse("11-11-2023")));
//	}
	
	@Autowired
	private EmployeeService emp;
	@Test
	void emp() {
		
	}

}
