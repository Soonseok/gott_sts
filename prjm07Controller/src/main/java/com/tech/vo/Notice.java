package com.tech.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 값을 전달 받는 생성자
@RequiredArgsConstructor //@NonNull로 전달 받을 값 지정
//@Data
public class Notice {
	
	@NonNull
	private String seq;
	@NonNull
	private String title;
	private String writer;
	private String content;
	
	
	private Date regdate;
	private int hit;
	
	
}
