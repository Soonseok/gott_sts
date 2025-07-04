package com.tech.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// String configLocation = "classpath:applicationCtx.xml";
		// AbstractApplicationContext ctx = new
		// GenericXmlApplicationContext(configLocation);

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student1.getName());
		System.out.println(student2.getName());
	}
}
