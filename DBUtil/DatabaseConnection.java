package com.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection provideDbConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/Student_Management_System";
		
		try {
			conn = DriverManager.getConnection(url, "root", "Root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
