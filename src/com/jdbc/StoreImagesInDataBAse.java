package com.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StoreImagesInDataBAse {
	 private static Connection con;
	private static PreparedStatement stat;
	private static FileInputStream fis;

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Kohlianu@645";
		String sql="update accounts set dp=? where id=?";
		Scanner sc = new Scanner(System.in);
		String path="C:\\Users\\harsh\\eclipse-workspace\\AdvancedJava\\images\\rock.jpg";
	    try {
			con = DriverManager.getConnection(url, username, password);
			stat = con.prepareStatement(sql);
			System.out.println("enter id");
			stat.setInt(2, sc.nextInt());
			try {
				fis = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			stat.setBinaryStream(1, fis);
			int i = stat.executeUpdate();
			
			System.out.println(i);
			
		  ResultSet execute = stat.executeQuery("select * from accounts");
			System.out.println("------------------------------------------------------");
		      System.out.printf("|%-5s | %-7s | %-11s| %-7s | %-10s |\n " ,"id","name","number","balance","branch");
		      
		     while(execute.next())
		     {
		    	 int id=execute.getInt("id");
		    	 String name = execute.getString("name");
		    	 int number = execute.getInt("number");
		    	int balance = execute.getInt("balance");
		    	String branch=execute.getString("branch");
		    	Blob dp= execute.getBlob("dp");
		    
		    	System.out.println("-----------------------------------------------------");
		    	System.out.printf("|%-5d | %-7s | %-10d | %-7d | %-10s |\n " ,id,name,number,balance,branch,dp);
		     }
		     System.out.println("-----------------------------------------------------");
			
			
			
			
			
			
		} catch (SQLException   e) {
			e.printStackTrace();
		}
	}

	
}
