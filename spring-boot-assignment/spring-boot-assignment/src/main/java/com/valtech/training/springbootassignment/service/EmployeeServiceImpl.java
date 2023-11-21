package com.valtech.training.springbootassignment.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entity.Employee;
import com.valtech.training.springbootassignment.repo.EmployeeRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	@PostConstruct
	public void populateOrders() {
		empRepo.save(new Employee("Praveen",21,5,100000));
		empRepo.save(new Employee("Pradeep",22,1,10000));
		empRepo.save(new Employee("Karthik",22,1,1000));
		
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println(empRepo.getClass().getName());
		return empRepo.save(employee);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee);
	}
	
	@Override
	public Employee getEmployee(long employeeId) {
		return empRepo.getReferenceById(employeeId);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	@Override
	public void deleteEmployeeById(long employeeId) {
		empRepo.deleteById(employeeId);
	}

}
