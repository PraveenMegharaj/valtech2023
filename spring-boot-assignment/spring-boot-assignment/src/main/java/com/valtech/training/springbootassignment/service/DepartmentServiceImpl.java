package com.valtech.training.springbootassignment.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entity.Department;
import com.valtech.training.springbootassignment.repo.DepartmentRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepo deptRepo;
	
	@Override
	@PostConstruct
	public void populateDepartment() {
		deptRepo.save(new Department("Development","Ground floor"));
		deptRepo.save(new Department("Finance","first floor"));
		deptRepo.save(new Department("HR","Second floor"));
		
	}
	
	@Override
	public Department createDepartment(Department department) {
		System.out.println(deptRepo.getClass().getName());
		return deptRepo.save(department);
	}
	
	@Override
	public Department updateDepartment(Department department) {
		return deptRepo.save(department);
	}
	
	@Override
	public Department getDepartment(long deptId) {
		return deptRepo.getReferenceById(deptId);
	}
	
	@Override
	public List<Department> getAllDepartments() {
		return deptRepo.findAll();
	}
	@Override
	public void deleteDepartmentById(long deptId) {
		deptRepo.deleteById(deptId);
	}
}
