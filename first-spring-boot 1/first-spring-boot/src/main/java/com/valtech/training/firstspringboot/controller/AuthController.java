package com.valtech.training.firstspringboot.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.model.ChangePasswordModel;
import com.valtech.training.firstspringboot.model.RegisterUserModel;
import com.valtech.training.firstspringboot.service.AuthService;
import com.valtech.training.firstspringboot.service.AuthServiceImpl;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute ChangePasswordModel pwdModel,Model model) {
		pwdModel.setUsername(userDetails.getUsername());
		if(Objects.equals(pwdModel.getNewPassword(), pwdModel.getConfirmPassword())) {
			
		}
		return "redirect:logout";
	}
	
	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute RegisterUserModel regUserModel,Model model) {
		if(regUserModel.getPassword().equals(regUserModel.getConfirmPassword())) {
			authService.createUser(regUserModel);
		}else {
			model.addAttribute("message","Password and Confirm Password doesnt match");
			return "regsiter";
		}
		return "login";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/anon")
	@ResponseBody
	public String anonPage() {
		return "Anonymous Page";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String userPage() {
		return "User Page";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin Page";
	}

}
