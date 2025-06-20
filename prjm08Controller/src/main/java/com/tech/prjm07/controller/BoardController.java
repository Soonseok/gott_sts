package com.tech.prjm07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.model.StudentInfo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@GetMapping("/")
	public String init() {
		
		return "index";
	}
	
	@GetMapping("/board/login")
	public String login() {
		
		return "/board/login";
	}
	
	@PostMapping("/board/loginconfirm")
	public String loginconfirm(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		
		return "/board/loginconfirm";
	}
	
	@RequestMapping("/board/studentform")
	public String studentForm() {
		
		return "/board/studentform";
	}
	
	@RequestMapping("/board/studentinfo")
	public String studentinfo(@ModelAttribute("studentinfo") StudentInfo studentInfo) {
		
		return "/board/studentinfo";
	}
}
