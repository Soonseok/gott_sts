package com.tech.prjm11.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.tech.prjm11.dto.GDto;

@Mapper
public interface IDao {
	public ArrayList<GDto> getAllList(int startRow, int endRow);
	public GDto contentView(String sgid);
	public int countTotalContents();
	public void upHit(String sbid);
}
