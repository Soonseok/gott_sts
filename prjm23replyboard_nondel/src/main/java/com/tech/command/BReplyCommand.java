package com.tech.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.tech.prjm09.dao.BDao;
import com.tech.prjm09.dto.BDto;

import jakarta.servlet.http.HttpServletRequest;

public class BReplyCommand implements BCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		String bindent=request.getParameter("bindent");
		String bstep=request.getParameter("bstep");
		String bgroup=request.getParameter("bgroup");
		
		BDao dao=new BDao();
		boolean replyResult = dao.reply(bid, bname, btitle, bcontent, bindent, bgroup, bstep);
		if(replyResult) {
			System.out.println("답변 작성 성공");
			request.setAttribute("result", "reply_success");
		}else {
			System.out.println("답변 작성 실패");
			request.setAttribute("result", "reply_failure");
		}
	}
}
