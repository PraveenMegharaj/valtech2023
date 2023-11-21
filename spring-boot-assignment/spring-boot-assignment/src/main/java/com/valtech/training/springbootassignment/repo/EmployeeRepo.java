package com.valtech.training.springbootassignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.springbootassignment.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	
}
