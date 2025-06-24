package com.tech.prjm11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.command.GCommand;
import com.tech.command.GListCommand;

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
}
