package com.tech.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice {
	
	private String seq;
	private String title;
	private String writer;
	private String content;
	
	
	private Date regdate;
	private int hit;
	
	
}
