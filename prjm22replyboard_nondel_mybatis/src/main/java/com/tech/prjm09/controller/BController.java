package com.tech.prjm09.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

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
	public String index() {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, SearchVO searchVO) {
		System.out.println("list() ctr");

		// 1. 페이지 번호 처리
		String strPage = request.getParameter("page");
		if (strPage == null || strPage.isEmpty()) {
			strPage = "1";
		}
		int page = Integer.parseInt(strPage);
		searchVO.setPage(page);

		// 2. 검색 처리
		String type = searchVO.getSearchType();     // 예: title, content, name
		String keyword = searchVO.getSearchKeyword(); // 사용자가 입력한 검색어

		System.out.println("검색 유형: " + type);
		System.out.println("검색어: " + keyword);

		// 3. 전체 게시물 수 (검색 포함)
		int total = iDao.selectBoardCount(type, keyword);
		searchVO.pageCalculate(total);

		// 4. 리스트 조회 (검색 포함)
		int startRow = searchVO.getRowStart();
		int endRow = searchVO.getRowEnd();
		ArrayList<BDto> list = iDao.list(type, keyword, startRow, endRow);

		// 5. model에 전달
		model.addAttribute("list", list);
		model.addAttribute("totRowCnt", total);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("searchType", type);
		model.addAttribute("query", keyword);

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
		System.out.println("write() mybatis");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		boolean result = iDao.write(bname, btitle, bcontent);
		
		String message = result ? "write_success" : "write_failure";
	    return "redirect:list?result=" + message;
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,
			Model model) {
		System.out.println("content_view() mybatis");
		String bid=request.getParameter("bid");
		iDao.upHit(bid);
		BDto dto = iDao.contentView(bid);
		model.addAttribute("content_view", dto);
		
		return "content_view";
	}
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request,
			Model model) {
		System.out.println("modify_view() mybatis");
		String bid=request.getParameter("bid");
		BDto dto = iDao.modifyView(bid);
		model.addAttribute("content_view", dto);
		
		return "modify_view";
	}
	
	@PostMapping("/modify")
	public String modify(HttpServletRequest request,
			Model model) {
		System.out.println("modify() mybatis");
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		boolean result = iDao.modify(bid, bname, btitle, bcontent);
		
		String message = result ? "modify_success" : "modify_failure";
	    return "redirect:list?result=" + message;
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view() mybatis");
		String bid=request.getParameter("bid");
		BDto dto = iDao.replyView(bid);
		model.addAttribute("reply_view", dto);
		
		return "reply_view";
	}
	
	@PostMapping("/reply")
	public String reply(HttpServletRequest request,
			Model model) {
		System.out.println("reply() mybatis");
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		String bindent=request.getParameter("bindent");
		String bstep=request.getParameter("bstep");
		String bgroup=request.getParameter("bgroup");
		iDao.replyShape(bgroup, bstep);
		boolean result = iDao.reply(bid, bname, btitle, bcontent, bindent, bgroup, bstep);
		
		String message = result ? "reply_success" : "reply_failure";
	    return "redirect:list?result=" + message;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
	    String bid = request.getParameter("bid");
	    String bgroup = request.getParameter("bgroup");

	    Map<String, Object> resultMap = iDao.check_indent(bid, bgroup);
	    System.out.println(resultMap);
	    
	    try {
	        BigDecimal stepObj = (BigDecimal) resultMap.get("OWN_STEP");
	        BigDecimal indentObj = (BigDecimal) resultMap.get("OWN_INDENT");
	        BigDecimal maxSameObj = (BigDecimal) resultMap.get("MAX_SAME");
	        BigDecimal maxIndentObj = (BigDecimal) resultMap.get("MAX_INDENT");

	        if (stepObj == null || indentObj == null || maxSameObj == null || maxIndentObj == null) {
	            return "redirect:list?result=delete_failure";
	        }

	        int ownStep = stepObj.intValue();
	        int ownIndent = indentObj.intValue();
	        int maxSame = maxSameObj.intValue();
	        int maxIndent = maxIndentObj.intValue();

	        boolean removable = (maxSame == ownStep) || 
	                            (maxSame != ownStep && ownIndent == maxIndent);

	        boolean result = false;
	        if (removable) {
	            result = iDao.delete(bid) > 0;
	        }

	        String message = result ? "delete_success" : "delete_failure";
	        return "redirect:list?result=" + message;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:list?result=delete_failure";
	    }
	}
}
