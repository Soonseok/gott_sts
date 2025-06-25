package com.tech.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.tech.prjm09.dao.BDao;

import jakarta.servlet.http.HttpServletRequest;

public class BDeleteCommand implements BCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String bid = request.getParameter("bid");
		String bgroup = request.getParameter("bgroup");
		BDao dao = new BDao();
		System.out.println("bgroup : "+bgroup);
		boolean delResult = dao.delete(bid, bgroup);
		if(delResult) {
			System.out.println("삭제 성공");
			request.setAttribute("result", "delete_success");
		}else {
			System.out.println("삭제 실패");
			request.setAttribute("result", "delete_failure");
		}
	}
}
