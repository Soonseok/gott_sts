package com.tech.anno1;

import org.springframework.stereotype.Component;

//@Component
public class College {
	private Principal principal;
		
	/*
	 * public College(Principal principal) { this.principal = principal; }
	 */

	// 생성자를 통한 주입
	public void test() {
		principal.principalInfo();
		System.out.println("testing is called method");
	}
	
	//setter를 통한 주입
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
}
