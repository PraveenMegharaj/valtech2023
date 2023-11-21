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

import com.valtech.training.springbootassignment.model.DepartmentModel;
import com.valtech.training.springbootassignment.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/deptlist")
	public String listDepartments(Model model) {
		model.addAttribute("dept",departmentService.getAllDepartments().stream().map(d->new DepartmentModel(d)).collect(Collectors.toList()));
		return "department/deptlist";
	}
	
	@GetMapping("/new")
	public String newDepartment(Model model) {
		model.addAttribute("dept",new DepartmentModel());
		return "department/edit";
	}
	
	@GetMapping("/edit")
	public String editDepartment(@RequestParam("deptId") long deptId, Model model) {
		model.addAttribute("dept",new DepartmentModel(departmentService.getDepartment(deptId)));
		return "department/edit";
	}
	
	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam("deptId") long deptId, Model model) {
		departmentService.deleteDepartmentById(deptId);
		model.addAttribute("dept",departmentService.getAllDepartments().stream().map(d->new DepartmentModel(d)).collect(Collectors.toList()));
		return "department/deptlist";
	}
	
	@PostMapping(path = "/save", params = "cancel")
	public String cancelEditDepartment(Model model) {
		model.addAttribute("dept",departmentService.getAllDepartments().stream().map(d->new DepartmentModel(d)).collect(Collectors.toList()));
		return "department/deptlist";
	}
	
	@PostMapping(path="/save",params = "submit")
	public String saveDepartment(@ModelAttribute DepartmentModel departmentModel,@RequestParam("submit") String submit, Model model ) {
			departmentService.createDepartment(departmentModel.getDepartment());
			model.addAttribute("dept",departmentService.getAllDepartments().stream().map(d->new DepartmentModel(d)).collect(Collectors.toList()));
		return "department/deptlist";
	}
}
