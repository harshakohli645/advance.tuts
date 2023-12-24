package com.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StoreLongText {
	private static Connection con;
	private static PreparedStatement stat;
	private static Scanner sc;

	public static void main(String[] args)  {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Kohlianu@645";
		String sql="update accounts set intro=? where id=?";
		sc = new Scanner(System.in);
		String path="C:\\Users\\harsh\\eclipse-workspace\\AdvancedJava\\images\\intro";
	    
		try {
			con = DriverManager.getConnection(url, username, password);
			stat = con.prepareStatement(sql);
			System.out.println("enter id:");
			stat.setInt(2, sc.nextInt());
			FileReader fis=new FileReader(path);
			stat.setCharacterStream(1, fis);
			int i = stat.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
