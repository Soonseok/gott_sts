package com.tech.prjm07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.model.Member;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
	
	@RequestMapping("/join/joinform")
	public String joinform() {
		
		return "/join/joinform";
	}
	
//	@RequestMapping("/join/joinview")
//	public String joinview(HttpServletRequest req, Model model) {
//		String id = req.getParameter("id");
//		String name = req.getParameter("name");
//		String email = req.getParameter("email");
//		
//		model.addAttribute("id", id);
//		model.addAttribute("name", name);
//		model.addAttribute("email", email);
//		
//		return "/join/joinview";
//	}
	
//	@RequestMapping("/join/joinview")
//	public String joinview(@RequestParam("id")String id, 
//			@RequestParam("name")String name, 
//			@RequestParam("email")String email, 
//			Model model) {
//		
//		model.addAttribute("id", id);
//		model.addAttribute("name", name);
//		model.addAttribute("email", email);
//		
//		return "/join/joinview";
//	}
	
//	@RequestMapping("/join/joinview")
//	public String joinview(@ModelAttribute("join") Member member) {
//		
//		
//		return "/join/joinview";
//	}
	
	@RequestMapping("/join/joinview")
	public String joinview(@RequestParam("id")String id, 
			@RequestParam("name")String name, 
			@RequestParam("email")String email, 
			Model model) {
		
		Member m = new Member();
		m.setId(id);
		m.setEmail(email);
		m.setName(name);
		model.addAttribute("member", m);
		
		return "/join/joinview";
	}
}
