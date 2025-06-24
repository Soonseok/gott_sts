package com.tech.prjm11.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GDto {
	private int gid;
	private String gname;
	private String gtitle;
	private String gcontent;
	private Timestamp gdate;
	private int ghit;
	private int ggroup;
	private int gstep;
	private int gindent;
}
