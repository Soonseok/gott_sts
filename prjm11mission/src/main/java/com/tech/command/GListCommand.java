package com.tech.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.tech.prjm11.dao.GDao;
import com.tech.prjm11.dto.GDto;

public class GListCommand implements GCommand{

	@Override
	public void execute(Model model) {
		System.out.println("GListCommand");
		GDao dao = new GDao();
		ArrayList<GDto> dtos = dao.getAllList();
		
		model.addAttribute("list", dtos);
	}

}
