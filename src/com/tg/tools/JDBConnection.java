package com.tg.tools;

import java.sql.*;

public class JDBConnection {
	private String dbDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver"; // 数据库的驱动
	private String url ="jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=TGDATA"; // URL地址
	public Connection connection = null;

	public JDBConnection() {
		try {
			Class.forName(dbDriver).newInstance(); // 加载数据库驱动
			connection = DriverManager.getConnection(url, "罗旗", "123"); // 加载数据
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
	}
}