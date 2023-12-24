package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Program3 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Kohlianu@645";
		Scanner sc = new Scanner(System.in);
		 
		 String sql="insert into `employeee`(`id`,`name`,`email`,`salary`,`dept`) values(?,?,?,?,?)";
		 try {
			 Connection conn = DriverManager.getConnection(url, username, password);
			 //Statement smt = conn.createStatement();
			 Jdbcclasses.display(conn, null, null);
			 
			 //int i = smt.executeUpdate(sql);
			 PreparedStatement stat = conn.prepareStatement(sql);
			 do {
				 System.out.println("enter Id:");
				 int id=sc.nextInt();
				 System.out.println("enter Name:");
				 String name = sc.next();
				 System.out.println("enter email:");
				 String email = sc.next();
				 System.out.println("enter salary:");
				 String salary = sc.next();
				 System.out.println("enter dept:");
				 String dept = sc.next();
				 stat.setInt(1, id);
				 stat.setString(2, name);
				 stat.setString(3, email);
				 stat.setString(4, salary);
				 stat.setString(5, dept);
				 int i = stat.executeUpdate();
				 //System.out.println(i);
				 System.out.println("do you want to enter more data? yes/no");
				 
				 
			 }
			 while(sc.next().equalsIgnoreCase("yes"));
			
			 
			 Jdbcclasses.display(conn, null, null);
			 
			 
			 
			 
			 
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
	}



}
