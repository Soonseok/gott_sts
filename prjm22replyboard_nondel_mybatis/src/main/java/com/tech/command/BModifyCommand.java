package com.tech.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.tech.prjm09.dao.BDao;
import com.tech.prjm09.dto.BDto;

import jakarta.servlet.http.HttpServletRequest;

public class BModifyCommand implements BCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		BDao dao=new BDao();
		boolean modifyResult = dao.modify(bid,bname,btitle,bcontent);
		if(modifyResult) {
			System.out.println("글 수정 성공");
			request.setAttribute("result", "modify_success");
		}else {
			System.out.println("글 수정 실패");
			request.setAttribute("result", "modify_failure");
		}
	}
}
