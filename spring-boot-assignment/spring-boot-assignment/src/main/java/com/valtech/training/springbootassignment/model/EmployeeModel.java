package com.valtech.training.springbootassignment.model;

import com.valtech.training.springbootassignment.entity.Employee;

public class EmployeeModel {

	private long employeeID;
	private String employeeName;
	private int age;
	private int experience;
	private int salary;
	
	public EmployeeModel() {
	}

	public EmployeeModel(Employee e) {
		this.employeeID = e.getEmployeeID();
		this.employeeName = e.getEmployeeName();
		this.age = e.getAge();
		this.experience = e.getExperience();
		this.salary = e.getSalary();
	}

	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee getEmployee() {
		return new Employee(employeeID, employeeName, age, experience, salary);
	}
}
