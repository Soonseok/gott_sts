package com.tech.anno1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.tech.anno1")
@Configuration
public class CollegeConfig {
	
	/*
	 * @Bean
	 * 
	 * @Bean(name = "col") public College college() { return new College(); }
	 */
}
