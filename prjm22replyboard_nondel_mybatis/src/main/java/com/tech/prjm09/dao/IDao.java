package com.tech.prjm09.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.tech.prjm09.dto.BDto;

@Mapper
public interface IDao {
	public ArrayList<BDto> list();
	public BDto contentView(String sbid);
	public BDto modifyView(String sbid);
	public BDto replyView(String sbid);
	public boolean write(String bname, String btitle, String bcontent);
	public boolean modify(String bid,String bname,
			String btitle,String bcontent);
	public boolean reply(String bid, String bname, String btitle, String bcontent, 
			String bindent, String bgroup, String bstep);
	public void replyShape(String strgroup, String strstep);
	public boolean check_indent(String sbid, String sbgroup);
	public boolean delete(String sbid, String sbgroup);
}
