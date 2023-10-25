package com.valtech.training.day3;

import java.util.Comparator;

public class SortByExperience implements Comparator<Employee> {
	public int compare (Employee o1, Employee o2) {
		return o1.experience - o2.experience;
	}
}
