package com.tech.anno1;

import org.springframework.stereotype.Component;

//@Component
public class College {
	private Principal principal;
		
	public College(Principal principal) {
		this.principal = principal;
	}


	public void test() {
		principal.principalInfo();
		System.out.println("testing is called method");
	}
}
