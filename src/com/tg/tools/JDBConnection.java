package com.tg.tools;

import java.sql.*;

public class JDBConnection {
	private String dbDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver"; // ���ݿ������
	private String url ="jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=TGDATA"; // URL��ַ
	public Connection connection = null;

	public JDBConnection() {
		try {
			Class.forName(dbDriver).newInstance(); // �������ݿ�����
			connection = DriverManager.getConnection(url, "����", "123"); // ��������
		} catch (Exception ex) {
			System.out.println("���ݿ����ʧ��");
		}
	}
}