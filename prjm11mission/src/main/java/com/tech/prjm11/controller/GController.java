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
import com.tech.prjm11.util.SearchVO;

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
	public String list(HttpServletRequest request, Model model, SearchVO searchVO) {
		System.out.println("list()");
		String strPage = request.getParameter("page");
		if(strPage==null || strPage=="") {
			strPage = "1";
		}
		int page = Integer.parseInt(strPage);
		searchVO.setPage(page);
		
		int total = iDao.countTotalContents();
		System.out.println("total : "+total);
		searchVO.pageCalculate(total);
		System.out.println("click page : "+strPage);
		System.out.println("start page : "+searchVO.getPageStart());
		System.out.println("end page : "+ searchVO.getPageEnd());
		System.out.println("total paging : "+searchVO.getTotPage());
		System.out.println("start row : "+searchVO.getRowStart());
		System.out.println("end row : "+searchVO.getRowEnd());
		
		int startRow = searchVO.getRowStart();
		int endRow = searchVO.getRowEnd();
		
		ArrayList<GDto> list = iDao.getAllList(startRow, endRow);
		model.addAttribute("list", list);
		model.addAttribute("totRowCnt", total);
		model.addAttribute("searchVO", searchVO);
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		String gid = request.getParameter("gid");
		iDao.upHit(gid);
		GDto dto = iDao.contentView(gid);
		model.addAttribute("content_view", dto);
		
		return "content_view";
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "write";
	}
}
