package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Transaction {
	static final Scanner sc = new Scanner(System.in);
	private static Connection conn;
	static final String sql="update `accounts` set `balance`=`balance`+? "
			+ "where number=?";
	private static PreparedStatement stat;
	static final String sql1="select balance from accounts where number=?";
	
	public static void main(String[] args)  {
	
	  String url="jdbc:mysql://localhost:3306/jdbcclasses";
	  String username="root";
	  String password="Kohlianu@645";
	  try {
		conn = DriverManager.getConnection(url, username, password);
	    conn.setAutoCommit(false);
	    diplay(conn);
		transaction();
		diplay(conn);
		//Valid.Balance(0);
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	static void diplay(Connection conn) throws SQLException 
	{
		Statement stat = conn.createStatement();
	
		ResultSet execute = stat.executeQuery("select * from accounts");
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
	private static void transaction() throws SQLException 
	{
		System.out.println("Enter sender number:");
		int senderNum = sc.nextInt();
		System.out.println("Enter Recevier Number:");
		int recevierNum = sc.nextInt();
		System.out.println("Enter amount to Send:");
		int amount = sc.nextInt();
		int balance = Valid.Balance(conn,senderNum);
		//System.out.println(balance);
		if(balance>=amount)
		{
			int i = updatesalary(-amount,senderNum);
			int j = updatesalary(amount,recevierNum);
			String rest="\u001B[0m";
			String yellow="\u001B[42m";
			
			if( isConfirm(i,j))
			{
				System.out.println(yellow+"Transaction is succussfully..."+rest);
				conn.commit();
			}
			else {
				String rest1="\u001B[0m";
				String yellow1="\u001B[41m";
				System.out.println(yellow1+"Transaction is failed....!"+rest1);
				conn.rollback();
			}
		}
		else {
			System.err.println("Insufficent balance..please Check your balance!!");
		}
	}
	private static boolean isConfirm(int i, int j) 
	{
		System.out.println("Do you want to send money (yes/no)?");
	
		String pin = sc.next();
		return pin.equalsIgnoreCase("yes") && i==1 &&j==1;
		
		
		
	}
	private static int updatesalary(int amount, int UserNum) throws SQLException 
	
	{
		
		 stat = conn.prepareStatement(sql);
		 stat.setInt(1, amount);
		 stat.setInt(2, UserNum);
		 int i = stat.executeUpdate();
		 return i;
		
	}
	
	

}
