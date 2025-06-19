package com.tech.prjm07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.tech.*"})
@SpringBootApplication
public class Prjm07ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prjm07ControllerApplication.class, args);
	}

}
