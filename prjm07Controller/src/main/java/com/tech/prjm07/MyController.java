package com.tech.prjm07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@RequestMapping("/login/loginform")
	public String loginform() {
		return "/login/loginform";
	}
	
	@RequestMapping("/login/loginconfirm")
	public String loginconfirm(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String hobby = request.getParameter("hobby");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("hobby", hobby);
		return "/login/loginconfirm";
	}
	
	
	
}
