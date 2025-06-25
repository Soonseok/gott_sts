package com.tech.anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class College {
	private Principal principal;
	private Teacher teacher;
		
	/*
	 * public College(Principal principal) { this.principal = principal; }
	 */

	// 생성자를 통한 주입
	public void test() {
		principal.principalInfo();
		teacher.teach();
		System.out.println("testing is called method");
	}
	
	// autowired는 component로 등록 된 객체를 자동으로 갖고 옴
	@Autowired
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	@Autowired
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
