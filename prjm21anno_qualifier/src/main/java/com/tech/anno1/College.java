package com.tech.anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class College {
	// setter에 autowired를 만들어 주지 않고 그냥 필드에 써도 된다.
	// 이제 티쳐가 2개다. 각각엔 promary와 repository가 붙어 있고, 보통은 primary가 우선이다.
	// 
	@Autowired
	private Principal principal;
	@Autowired
	//@Qualifier("t1")
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
	
//	// autowired는 component로 등록 된 객체를 자동으로 갖고 옴
//	@Autowired
//	public void setPrincipal(Principal principal) {
//		this.principal = principal;
//	}
//
//	@Autowired
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
}
