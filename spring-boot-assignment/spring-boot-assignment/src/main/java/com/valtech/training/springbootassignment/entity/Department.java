package com.valtech.training.springbootassignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deptId;
	private String deptName;
	private String deptLocation;
	
	public Department() {
	}
	
	public Department(long deptId, String deptName, String deptLocation) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLocation = deptLocation;
	}

	public Department(String deptName, String deptLocation) {
		super();
		this.deptName = deptName;
		this.deptLocation = deptLocation;
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

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLocation=" + deptLocation + "]";
	}
	
	
}
