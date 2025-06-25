package com.tech.anno1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/tech/anno1/beans.xml");
		System.out.println("beans.xml file loaded");
		College college = context.getBean("College", College.class);
		System.out.println("This is obj college : "+college);
		
		
	}
}
