package com.tech.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.tech.prjm11.dao.GDao;
import com.tech.prjm11.dto.GDto;

import jakarta.servlet.http.HttpServletRequest;

public class GContentCommand implements GCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = 
				(HttpServletRequest) map.get("request");
		String gid = request.getParameter("gid");
		GDao dao = new GDao();
		GDto dto = dao.contentView(gid);
		System.out.println("gid : "+request.getParameter("gid"));
		
		model.addAttribute("content_view", dto);
	}

}
