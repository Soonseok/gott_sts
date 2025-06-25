package com.tech.anno1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ComponentScan(basePackages = "com.tech.anno1")
@Configuration
public class CollegeConfig {
	@Bean
	public College college() {
		//return new College(principalBean());
		College college = new College();
		college.setPrincipal(principalBean());
		college.setTeacher(mathTeacher());
		return college;
	}
	
	@Bean
	public Principal principalBean() {
		return new Principal();
	}
	
	@Bean
	public MathTeacher mathTeacher() {
		return new MathTeacher();
	}
}
