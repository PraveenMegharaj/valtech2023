package com.valtech.training.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	
	public String hello() {
		return "Hello Spring Boot";
	}
	
}
