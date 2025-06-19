package com.tech.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	//bean 등록
	@Bean
	public Student student1() {
		Student student = new Student("김도희", "20");
		student.setGradeNum("3");
		student.setClassNum("Cosmology");
		
		return student;
	}
	
	@Bean
	public Student student2() {
		Student student = new Student("정민하", "20");
		student.setGradeNum("7");
		student.setClassNum("Singing");
		
		return student;
	}
	
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo(student1());
		
		return studentInfo;
	}
}
