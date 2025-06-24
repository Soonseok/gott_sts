package com.tech.prjm11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.command.GCommand;
import com.tech.command.GContentCommand;
import com.tech.command.GListCommand;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GController {
	GCommand command;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new GListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		model.addAttribute("request", request);
		command = new GContentCommand();
		command.execute(model);
		return "content_view";
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "write";
	}
}
