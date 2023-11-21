package com.valtech.training.springbootassignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.springbootassignment.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
