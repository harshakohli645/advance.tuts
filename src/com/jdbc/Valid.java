package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Valid {
	private static Connection conn;
	static final String sql="select * from accounts where number=?";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		 String url="jdbc:mysql://localhost:3306/jdbcclasses";
		 String username="root";
		 String password="Kohlianu@645";
		 try {
				conn = DriverManager.getConnection(url, username, password);
				
				System.out.println(Balance(conn,number));
			    
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static int Balance(Connection conn,int number) throws SQLException 
	{
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, number);
		ResultSet res = stat.executeQuery();
		int balance=0;
		while(res.next())
		{
			 balance = res.getInt("balance");
		}
		return balance;
		
		
	}

}
