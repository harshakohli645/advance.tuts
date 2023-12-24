package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Kohlianu@645";
		 
		 String sql="insert into `employeee`(`id`,`name`,`email`,`salary`,`dept`) values(564,'veera','veera@gmail.com','21000','Sales')";
		 try {
			 Connection conn = DriverManager.getConnection(url, username, password);
			 Statement smt = conn.createStatement();
			 
			 int i = smt.executeUpdate(sql);
			 System.out.println(i);
			 
			 Jdbcclasses.display(conn, null, null);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

}
