package com.tech.anno1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
@Repository("t2")
public class MathTeacher2 implements Teacher{

	@Override
	public void teach() {
		System.out.println("hi, this is Math Teacher2");
		System.out.println("my name is Soha");
	}

}
