package com.tech.prjm07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RedirectController {
	
	@RequestMapping("/join/studentConfirm")
	public String studentRedirect(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		if(id.contentEquals("abc")) {
			return "redirect:studentOk";
		}else {
			return "redirect:studentNotOk";
		}
	}
	@RequestMapping("/join/studentOk")
	public String studentOk() {
		return "/join/studentOk";
	}
	@RequestMapping("/join/studentNotOk")
	public String studentNotOk() {
		return "/join/studentNotOk";
	}
	
	
}
