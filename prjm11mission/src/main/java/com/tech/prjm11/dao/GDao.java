package com.tech.prjm11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.tech.prjm11.dto.GDto;
import com.tech.prjm11.util.DBCon;

public class GDao {
	Connection conn = null;
	public ArrayList<GDto> getAllList(){
		ArrayList<GDto> dtos = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select gid, gname, gtitle, gcontent, gdate, ghit, ggroup, gstep, gindent "
					+ "from guroboard order by gid desc";
			conn = DBCon.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int gid = rs.getInt("gid");
				String gname = rs.getString("gname");
				String gtitle = rs.getString("gtitle");
				String gcontent = rs.getString("gcontent");
				Timestamp gdate = rs.getTimestamp("gdate");
				int ghit = rs.getInt("ghit");
				int ggroup = rs.getInt("ggroup");
				int gstep = rs.getInt("gstep");
				int gindent = rs.getInt("gindent");
				GDto dto = new GDto(gid, gname, gtitle, gcontent, gdate, ghit, ggroup, gstep, gindent);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public GDto contentView(String sgid) {
		GDto dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBCon.getConnection();
			upHit(sgid, conn);
			String sql = "select gid, gname, gtitle, gcontent, gdate, ghit, ggroup, gstep, gindent "
					+ "from guroboard where gid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sgid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int gid = rs.getInt("gid");
				String gname = rs.getString("gname");
				String gtitle = rs.getString("gtitle");
				String gcontent = rs.getString("gcontent");
				Timestamp gdate = rs.getTimestamp("gdate");
				int ghit = rs.getInt("ghit");
				int ggroup = rs.getInt("ggroup");
				int gstep = rs.getInt("gstep");
				int gindent = rs.getInt("gindent");
				dto = new GDto(gid, gname, gtitle, gcontent, gdate, ghit, ggroup, gstep, gindent);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
			}
		}
		return dto;
	}
	
	public void upHit(String sgid, Connection gconn) {
		PreparedStatement pstmt = null;
		try {
			String sql = "update guroboard set ghit=ghit+1 where gid=?";
			pstmt = gconn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sgid));
			int rn = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
