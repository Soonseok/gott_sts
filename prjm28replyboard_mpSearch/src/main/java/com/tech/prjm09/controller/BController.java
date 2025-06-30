package com.tech.prjm09.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.command.BCommand;
import com.tech.command.BContentCommand;
import com.tech.command.BDeleteCommand;
import com.tech.command.BListCommand;
import com.tech.command.BModifyCommand;
import com.tech.command.BModifyViewCommand;
import com.tech.command.BReplyCommand;
import com.tech.command.BReplyViewCommand;
import com.tech.command.BWriteCommand;
import com.tech.prjm09.dao.IDao;
import com.tech.prjm09.dto.BDto;
import com.tech.prjm09.util.SearchVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BController {
	BCommand command;
	
	private final IDao iDao;
	
	@Autowired
	public BController(IDao iDao) {
		this.iDao = iDao;
	}
	
	@RequestMapping("/")
	public String init() {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, SearchVO searchVO) {
		System.out.println("list() ctr");
		//기본페이지
		String strPage = request.getParameter("page");
		if(strPage==null || strPage=="" || strPage == "0") {
			strPage = "1";
		}
		//검색
		String btitle = "";
		String bcontent = "";
		String[] brdTitle = request.getParameterValues("searchType");
		if(brdTitle != null) {
			for (String val : brdTitle) {
				if(val.equals("btitle")) {
					model.addAttribute("btitle", "true");
					btitle = "btitle";
				}
				if(val.equals("bcontent")) {
					model.addAttribute("bcontent", "true");
					bcontent = "bcontent";
				}
			}
		}
		String searchKeyword = request.getParameter("sk");
		if(searchKeyword == null) {
			searchKeyword = "";
		}
		
		int total = 0;
		//페지네이션에 영향을 줄 검색
		if(btitle.equals("btitle") && bcontent.equals("")) {
			total = iDao.selectBoardCount(searchKeyword, "1");
		}else if(btitle.equals("") && bcontent.equals("bcontent")) {
			total = iDao.selectBoardCount(searchKeyword, "2");
		}else if(btitle.equals("btitle") && bcontent.equals("bcontent")) {
			total = iDao.selectBoardCount(searchKeyword, "3");
		}else if(btitle.equals("") && bcontent.equals("")) {
			total = iDao.selectBoardCount(searchKeyword, "4");
		}
		searchVO.pageCalculate(total);
		
		//pagination
		int page = Integer.parseInt(strPage);
		searchVO.setPage(page);		
		int startRow = searchVO.getRowStart();
		int endRow = searchVO.getRowEnd();
		
		if(btitle.equals("btitle") && bcontent.equals("")) {
			model.addAttribute("list", iDao.list(startRow, endRow, searchKeyword, "1"));
		}else if(btitle.equals("") && bcontent.equals("bcontent")) {
			model.addAttribute("list", iDao.list(startRow, endRow, searchKeyword, "2"));
		}else if(btitle.equals("btitle") && bcontent.equals("bcontent")) {
			model.addAttribute("list", iDao.list(startRow, endRow, searchKeyword, "3"));
		}else if(btitle.equals("") && bcontent.equals("")) {
			model.addAttribute("list", iDao.list(startRow, endRow, searchKeyword, "4"));
		}
		
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("totRowCnt", total);
		model.addAttribute("searchVO", searchVO);
		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view() ctr");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,
			Model model) {
		System.out.println("write() ctr");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		iDao.write(bname, btitle, bcontent);
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,
			Model model) {
		System.out.println("content_view() ctr");
		String bid=request.getParameter("bid");
		BDto dto = iDao.contentView(bid);
		model.addAttribute("content_view",dto);
		return "content_view";
	}
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request,
			Model model) {
		System.out.println("modify_view() ctr");
		String bid=request.getParameter("bid");
		BDto dto = iDao.modifyView(bid);
		model.addAttribute("content_view", dto);
		return "modify_view";
	}
	
	@PostMapping("/modify")
	public String modify(HttpServletRequest request,
			Model model) {
		System.out.println("modify() ctr");
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		iDao.modify(bid, bname, btitle, bcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view() ctr");
		String bid=request.getParameter("bid");
		BDto dto = iDao.replyView(bid);
		model.addAttribute("reply_view", dto);
		
		return "reply_view";
	}
	
	@PostMapping("/reply")
	public String reply(HttpServletRequest request,
			Model model) {
		System.out.println("reply() ctr");
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		String bindent=request.getParameter("bindent");
		String bstep=request.getParameter("bstep");
		String bgroup=request.getParameter("bgroup");
		iDao.replyShape(bgroup, bstep);
		iDao.reply(bid, bname, btitle, bcontent, bindent, bgroup, bstep);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete() ctr");
		String bid = request.getParameter("bid");
		iDao.delete(bid);
		
		return "redirect:list";
	}
	
}
