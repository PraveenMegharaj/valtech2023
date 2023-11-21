package com.valtech.training.springbootassignment.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.springbootassignment.model.EmployeeModel;
import com.valtech.training.springbootassignment.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employeelist")
	public String listEmployees(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployees().stream().map(e->new EmployeeModel(e)).collect(Collectors.toList()));
		return "employees/employeelist";
	}
	
	@GetMapping("/new")
	public String newEmployee(Model model) {
		model.addAttribute("employees",new EmployeeModel());
		return "employees/edit";
	}
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam("employeeID") long employeeID, Model model) {
		model.addAttribute("employees",new EmployeeModel(employeeService.getEmployee(employeeID)));
		return "employees/edit";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeID") long employeeID, Model model) {
		employeeService.deleteEmployeeById(employeeID);
		model.addAttribute("employees",employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employees/employeelist";
	}
	
	@PostMapping(path = "/save", params = "cancel")
	public String cancelEditEmployee(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employees/employeelist";
	}
	
	@PostMapping(path="/save",params = "submit")
	public String saveEmployee(@ModelAttribute EmployeeModel employeeModel,@RequestParam("submit") String submit, Model model ) {
			employeeService.createEmployee(employeeModel.getEmployee());
		model.addAttribute("employees",employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employees/employeelist";
	}
}
