package com.valtech.training.firstspringboot.config;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.valtech.training.firstspringboot.component.Arithmetic;
import com.valtech.training.firstspringboot.component.ArithmeticImpl;
import com.valtech.training.firstspringboot.component.SimpleInterest;
import com.valtech.training.firstspringboot.component.SimpleInterestImpl;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		
		.antMatchers("/user","/orders/**")
		.hasAnyRole("USER","ADMIN")
		
		.antMatchers("/admin")
		.hasRole("ADMIN")
		
		.antMatchers("/anon","/login","/logout")
		.anonymous()
		
		.anyRequest()
		.authenticated();
		
//		http.httpBasic();
		http.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/hello?name=Valtech")
		.failureUrl("/login?error=true");
		
		return http.build();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		UserDetails root=org.springframework.security.core.userdetails.User.builder().username("root").password("root").roles("USER").build();
		UserDetails admin=org.springframework.security.core.userdetails.User.builder().username("admin").password("admin").roles("ADMIN","USER").build();
		return new InMemoryUserDetailsManager(root,admin);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
//	@Bean
//	public Arithmetic arithmetic() {
//		return new ArithmeticImpl();
//	}
//	
//	@Bean
//	public SimpleInterest simpleInterest() {
//		return new SimpleInterestImpl();
//	}
}
