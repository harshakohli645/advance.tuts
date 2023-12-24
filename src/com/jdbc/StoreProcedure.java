package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoreProcedure {
	private static Connection con;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 String url="jdbc:mysql://localhost:3306/jdbcclasses";
		  String username="root";
		  String password="Kohlianu@645";
		  String sql ="{call display(?)}";
		  try {
			con = DriverManager.getConnection(url, username, password);
			
			CallableStatement pre = con.prepareCall(sql);
			System.out.println("enter salary :");
			pre.setInt(1, sc.nextInt());
			//pre.registerOutParameter(1, Types.INTEGER);
			pre.execute();
//			int count = pre.getInt(1);
//			System.out.println(count);
//			
			ResultSet execute = pre.getResultSet();
			System.out.println("------------------------------------------------------");
		      System.out.printf("|%-5s | %-7s | %-11s| %-7s | %-10s |\n " ,"id","name","number","balance","branch");
		      
		     while(execute.next())
		     {
		    	 int id=execute.getInt("id");
		    	 String name = execute.getString("name");
		    	 int number = execute.getInt("number");
		    	int balance = execute.getInt("balance");
		    	String branch= execute.getString("branch");
		    	System.out.println("-----------------------------------------------------");
		    	System.out.printf("|%-5d | %-7s | %-10d | %-7d | %-10s |\n " ,id,name,number,balance,branch);
		     }
		     System.out.println("-----------------------------------------------------");
			
			
			
			
			
			
			
			
			
			
			
			
			
		} 
		  catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
