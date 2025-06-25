package com.tech.anno1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service("t1")
@Primary
public class MathTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("hi, this is Math Teacher");
		System.out.println("my name is Dohee");
	}

}
