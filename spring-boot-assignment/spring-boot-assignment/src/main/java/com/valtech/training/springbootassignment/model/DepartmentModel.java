package com.valtech.training.springbootassignment.model;

import com.valtech.training.springbootassignment.entity.Department;

public class DepartmentModel {

	private long deptId;
	private String deptName;
	private String deptLocation;
	
	public DepartmentModel() {
	}
	
	public DepartmentModel(Department d) {
		this.deptId = d.getDeptId();
		this.deptName = d.getDeptName();
		this.deptLocation = d.getDeptLocation();
	}

	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}
	public Department getDepartment() {
		return new Department(deptId, deptName, deptLocation);
	}
	
}
