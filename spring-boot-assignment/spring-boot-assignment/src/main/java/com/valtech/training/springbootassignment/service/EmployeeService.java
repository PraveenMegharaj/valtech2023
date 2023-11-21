package com.valtech.training.springbootassignment.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.valtech.training.springbootassignment.entity.Employee;

public interface EmployeeService {

	void populateOrders();

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);


	List<Employee> getAllEmployees();

	Employee getEmployee(long employeeId);

	void deleteEmployeeById(long employeeId);

}