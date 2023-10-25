package com.valtech.training.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {
	
	int Seniority;
	int experience;
	String Name;
	int Age;
	double salary;
	
	public Employee (int Seniority, int experience, String Name, int Age, double salary) {
		this.Seniority = Seniority;
		this.experience = experience;
		this.Name = Name;
		this.Age = Age;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Seniority = "+Seniority+" expereience = "+experience+" Name = "+Name+" Age = "+Age+" salary = "+salary;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Employee> ar = new ArrayList<>();
		ar.add(new Employee(10,10,"Rahul",40,60000));
		ar.add(new Employee(11,11,"Varun",44,80000));
		ar.add(new Employee(1,1,"arun",24,8000));
		ar.add(new Employee(3,11,"dharun",34,70000));
		ar.add(new Employee(5,7,"tarun",28,40000));
		
//		for(int i=0;i<ar.size();i++)
//			System.out.println(ar.get(i));
		System.out.println("Sorting by Seniority");
		Collections.sort(ar, new SortBySeniority());
		for(Employee e:ar) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("Sorting by Name");
		Collections.sort(ar, new SortByName());
		for(Employee e:ar) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("Sorting by Exp");
		Collections.sort(ar, new SortByExperience());
		for(Employee e:ar) {
			System.out.println(e);
		}
		System.out.println();
		
	}

}
