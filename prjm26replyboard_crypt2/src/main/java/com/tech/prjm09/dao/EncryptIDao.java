package com.tech.prjm09.dao;

import org.apache.ibatis.annotations.Mapper;

import com.tech.prjm09.dto.CMember;

@Mapper
public interface EncryptIDao {
	public void join(String id, String pass, String bcpwd, String shapwd);
	public CMember getMember(String id);
}
