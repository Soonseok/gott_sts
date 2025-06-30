package com.tech.prjm09.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tech.command.BCommand;
import com.tech.prjm09.dao.IDao;
import com.tech.prjm09.dto.BDto;
import com.tech.prjm09.dto.ReBrdImgDto;
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
	
//	@RequestMapping("/write")
//	public String write(HttpServletRequest request,
//			Model model) {
//		System.out.println("write() ctr");
//		String bname=request.getParameter("bname");
//		String btitle=request.getParameter("btitle");
//		String bcontent=request.getParameter("bcontent");
//		iDao.write(bname, btitle, bcontent);
//		return "redirect:list";
//	}
	@RequestMapping("/write")
	public String write(MultipartHttpServletRequest mtfRequest,
			Model model) {
		System.out.println("write() ctr");
		String bname=mtfRequest.getParameter("bname");
		String btitle=mtfRequest.getParameter("btitle");
		String bcontent=mtfRequest.getParameter("bcontent");
		iDao.write(bname, btitle, bcontent);
		int bid = iDao.selectBid();
		
		String workPath = System.getProperty("user.dir");
		System.out.println(workPath);
		//String root = "C:\\hsts2025\\sts25_work\\prjm29replyboard_mpsupdown_multi\\src\\main\\resources\\static\\files";
		String root = workPath + "\\src\\main\\resources\\static\\files";
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		for (MultipartFile mf : fileList) {
			String originalFile = mf.getOriginalFilename();
			System.out.println(originalFile);
			long milsec = System.currentTimeMillis();
			String changeFile = milsec + "_" + originalFile;
			System.out.println(changeFile);
			
			try {
				String pathFile = root + "\\" + changeFile;
				if(!originalFile.equals("")) {
					mf.transferTo(new File(pathFile));
					System.out.println("Upload Successed");
					iDao.imgwrite(bid, originalFile, changeFile);
					System.out.println("rebrdimgtb write successed");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,
			Model model) {
		System.out.println("content_view() ctr");
		String bid=request.getParameter("bid");
		BDto dto = iDao.contentView(bid);
		model.addAttribute("content_view",dto);
		
		ArrayList<ReBrdImgDto> imgList = iDao.selectImg(bid);
		model.addAttribute("imgList", imgList);
		
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
