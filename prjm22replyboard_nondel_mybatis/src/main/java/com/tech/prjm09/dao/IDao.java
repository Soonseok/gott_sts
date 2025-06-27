package com.tech.prjm09.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tech.prjm09.dto.BDto;

@Mapper
public interface IDao {
	ArrayList<BDto> list(String type, String keyword, int start, int end);
	int selectBoardCount(String type, String keyword);
	public BDto contentView(String sbid);
	public BDto modifyView(String sbid);
	public BDto replyView(String sbid);
	public boolean write(String bname, String btitle, String bcontent);
	public boolean modify(String bid,String bname,
			String btitle,String bcontent);
	public boolean reply(String bid, String bname, String btitle, String bcontent, 
			String bindent, String bgroup, String bstep);
	public void replyShape(String strgroup, String strstep);
	public void upHit(String sbid);
	public Map<String, Object> check_indent(String sbid, String sbgroup);
	public int delete(String sbid);
}
