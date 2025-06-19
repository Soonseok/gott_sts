package com.tech.prjm05img;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("abcd")
	public String abcd() {//메서드 이름은 url 이름임.
		System.out.println("test abcd");
		return "test"; //이 리턴은 파일 이름이어야 함.
	}
	
	@RequestMapping("/")
	public String home() {//메서드 이름은 url 이름임.
		System.out.println("home");
		return "../home"; //이 리턴은 파일 이름이어야 함.
	}
	
	@RequestMapping("bank")
	public String bank() {//메서드 이름은 url 이름임.
		System.out.println("bank");
		return "bank"; //이 리턴은 파일 이름이어야 함.
	}
}
