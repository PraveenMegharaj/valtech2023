package com.valtech.training.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.springboot.component.HelloWorld;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private HelloWorld helloWorld;

	@Test
	void hello() {
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}
	

}
