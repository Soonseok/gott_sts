package com.tech.prjm09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.command.BCommand;
import com.tech.command.BListCommand;

@Controller
public class BController {
	
	BCommand command;
	
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
}
