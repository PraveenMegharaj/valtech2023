package com.valtech.training.springbootassignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeID;
	private String employeeName;
	private int age;
	private int experience;
	private int salary;
	
	public Employee() {
	}
	
	public Employee(long employeeID, String employeeName, int age, int experience, int salary) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.age = age;
		this.experience = experience;
		this.salary = salary;
	}

	public Employee(String employeeName, int age, int experience, int salary) {
		super();
		this.employeeName = employeeName;
		this.age = age;
		this.experience = experience;
		this.salary = salary;
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

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", age=" + age
				+ ", experience=" + experience + ", salary=" + salary + "]";
	}
	
	
}
