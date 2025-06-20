package com.tech.prjm09.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	static Connection conn = null;
	public static Connection getConnection() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			String user = "blue";
			String password = "123456";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공 from getConnection()");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
