package com.tech.prjm09.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.tech.prjm09.dto.BDto;
import com.tech.prjm09.util.DBCon;

public class BDao {
	Connection conn = null;
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBCon.getConnection();
			String sql = "select bid,bname,btitle,bcontent,"
					+ "bdate,bhit,bgroup,bstep,bindent "
					+ "from replyboard "
					+ "order by bgroup desc, bstep asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				BDto dto = new BDto(bid, bname, btitle,
						bcontent, bdate, bhit, bgroup,
						bstep, bindent);
				dtos.add(dto);
			}		
		} catch (Exception e) {
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {}
			}
		return dtos;
	}
	
	public void write(String bname, String btitle,
			String bcontent) {
		PreparedStatement pstmt = null;
		
		try {
			conn = DBCon.getConnection();
			String query = "insert into replyboard(bid,bname,btitle,"
					+ "bcontent,bdate,bhit,bgroup,bstep,bindent) "
					+ "values(replyboard_seq.nextval,?,?,"
					+ "?,sysdate,0,replyboard_seq.currval,0,0)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
			}
		}
	}
	
	public BDto contentView(String sbid) {
		upHit(sbid);
		
		BDto dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBCon.getConnection();
			String query = "select bid,bname,btitle,bcontent,"
					+ "bdate,bhit,bgroup,bstep,bindent "
					+ "from replyboard where bid = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(sbid));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				dto = new BDto(bid, bname, btitle,
						bcontent, bdate, bhit, bgroup,
						bstep, bindent);
			}	
		} catch (Exception e) {
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
	
	public BDto modifyView(String sbid) {
		BDto dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBCon.getConnection();
			String query = "select bid,bname,btitle,bcontent,"
					+ "bdate,bhit,bgroup,bstep,bindent "
					+ "from replyboard where bid = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(sbid));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				dto = new BDto(bid, bname, btitle,
						bcontent, bdate, bhit, bgroup,
						bstep, bindent);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void upHit(String sbid){
		PreparedStatement pstmt = null;
		try {
			conn  =  DBCon.getConnection();
			String sql = "update replyboard set bhit = bhit+1 where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
			int rn  =  pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void modify(String bid,String bname,
			String btitle,String bcontent) {
		PreparedStatement pstmt = null;
		try {
			conn = DBCon.getConnection();
			String query = "update replyboard "
					+ "set bname = ?,btitle = ?,bcontent = ? "
					+ "where bid = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bid);
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
			}
		}
	}
	
	public void reply(String bid, String bname, String btitle, String bcontent, 
			String bindent, String bgroup, String bstep) {
		
		replyShape(bgroup, bstep);
		PreparedStatement pstmt = null;
		try {
			conn = DBCon.getConnection();
			String sql = "insert into replyboard(bid,bname,btitle,"
					+ "bcontent,bgroup,bstep,bindent) "
					+ "values(replyboard_seq.nextval,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, Integer.parseInt(bgroup));
			pstmt.setInt(5, Integer.parseInt(bstep)+1);
			pstmt.setInt(6, Integer.parseInt(bindent)+1);
			int rn  =  pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public BDto replyView(String sbid) {
		BDto dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBCon.getConnection();
			String query = "select bid,bname,btitle,bcontent,"
					+ "bdate,bhit,bgroup,bstep,bindent "
					+ "from replyboard where bid = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(sbid));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				dto = new BDto(bid, bname, btitle,
						bcontent, bdate, bhit, bgroup,
						bstep, bindent);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void replyShape(String strgroup, String strstep) {
		PreparedStatement pstmt = null;
		try {
			conn = DBCon.getConnection();
			String sql = "update replyboard set bstep=bstep+1 where bgroup=? and bstep>?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strgroup));
			pstmt.setInt(2, Integer.parseInt(strstep));
			int rn  =  pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public boolean check_indent(String sbid, String sbgroup, Connection conn) {
		int max_indent = 0;
		int own_indent = 0;
		int own_step = 0;
		int max_same = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select (select bindent from replyboard where bid=?) as own_indent, "
					+ "(select bstep from replyboard where bid=?) as own_step, "
					+ "(select max(bindent) from replyboard where bgroup=? and bstep=bindent) as max_same, "
					+ "max(bindent) as max_indent from replyboard where bgroup=? group by bgroup";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sbid);
			pstmt.setString(2, sbid);
			pstmt.setString(3, sbgroup);
			pstmt.setString(4, sbgroup);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				max_indent = rs.getInt("max_indent");
				own_indent = rs.getInt("own_indent");
				own_step = rs.getInt("own_step");
				max_same = rs.getInt("max_same");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(max_same == own_step) {
			return true;
		}
		if((max_same != own_step)&&(own_indent == max_indent)) {
			return true;
		}
		return false;
	}
	
	public boolean delete(String sbid, String sbgroup) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCon.getConnection();
			boolean removable = check_indent(sbid, sbgroup, conn);
			if(removable) {
				String sql = "delete from replyboard where bid=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(sbid));
				int rn = pstmt.executeUpdate();
				result = (rn > 0);
			}else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
