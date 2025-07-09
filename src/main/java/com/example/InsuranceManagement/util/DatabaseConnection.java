package com.example.InsuranceManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static String db_url="jdbc:mysql://localhost:3306/insurance_db";
	private static String db_user="root";
	private static String db_pswd="root";
	static Connection con;
	
	static {
		try {
			con=DriverManager.getConnection(db_url,db_user,db_pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return con;
	}

}
