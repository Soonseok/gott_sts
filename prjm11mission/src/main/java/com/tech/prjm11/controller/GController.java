package com.tech.prjm11.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.command.GCommand;
import com.tech.command.GContentCommand;
import com.tech.command.GListCommand;
import com.tech.prjm11.dao.IDao;
import com.tech.prjm11.dto.GDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GController {
	GCommand command;
	
	private final IDao iDao;
	@Autowired
	public GController(IDao iDao) {
		this.iDao = iDao;
	} 
	
	@RequestMapping("/")
	public String init() {
		return "redirect:list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
//		command = new GListCommand();
//		command.execute(model);
		ArrayList<GDto> list = iDao.getAllList();
		model.addAttribute("list", list);
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
