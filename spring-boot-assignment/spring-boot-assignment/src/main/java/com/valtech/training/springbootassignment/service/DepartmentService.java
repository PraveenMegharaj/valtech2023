package com.valtech.training.springbootassignment.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.valtech.training.springbootassignment.entity.Department;

public interface DepartmentService {

	void populateDepartment();

	Department createDepartment(Department department);

	Department updateDepartment(Department department);

	Department getDepartment(long deptId);

	List<Department> getAllDepartments();

	void deleteDepartmentById(long deptId);

}