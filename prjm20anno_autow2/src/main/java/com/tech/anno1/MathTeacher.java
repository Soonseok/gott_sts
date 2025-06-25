package com.tech.anno1;

import org.springframework.stereotype.Component;

@Component
public class MathTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("hi, this is Math Teacher");
		System.out.println("my name is Dohee");
	}

}
