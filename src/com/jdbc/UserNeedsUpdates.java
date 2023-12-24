package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UserNeedsUpdates {

	private static Connection con;
	private static Statement stat;

	public static void main(String[] args) throws SQLException 
	{
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Kohlianu@645";
		 Connection conn=null;
		 Statement smt=null;
		 ResultSet res=null;
		 con=DriverManager.getConnection(url,username,password);
		 int n=select();
		// System.out.println(n);
		 UserCustomize(n,con,url,username,password);
		 
			   
	    
	}

	private static void UserCustomize(int n, Connection con, String url, String username, String password) throws SQLException
	
	{
		
		switch(n)
		{
		   case 1:
			   insert(con,url,username,password);
		   case 2:
			   select1(con,url,username,password);
			   
		   case 3:
			   delete(con,url,username,password);
		}
			   
	}
	private static void delete(Connection con2, String url, String username, String password) throws SQLException 
	{
		Scanner sc=new Scanner(System.in);
		Jdbcclasses.display(con2, stat, null);
		System.out.println("If you want delete row?Please enter Correct ID?");
		int row=sc.nextInt();
		String sql="delete from employeee where id=?";
		PreparedStatement stat = con2.prepareStatement(sql);
		stat.setInt(1, row);
		int i = stat.executeUpdate();
		Jdbcclasses.display(con2, stat, null);
		int n = select();
		UserCustomize( n,  con2, url,  username,  password);
		
	}

	private static void select1(Connection con2, String url, String username, String password) throws SQLException 
	{
		int op=content();
		
		switch(op)
		{
		 case 1:
			 id(con2,url,username,password);
		 case 2:
			 name(con2,url,username,password);
		 case 3:
			 email(con2,url,username,password);
		 case 4:
			 salary(con2,url,username,password);
		 case 5:
			 dept(con2,url,username,password);
		 case 6:
			 Jdbcclasses.display(con,null,null);
		 case 7:
			 selectCustomize(con2,url,username,password);
		 case 8:
			 int n = select();
			 UserCustomize(n, con2, url, username, password);
			 
			 
			 			 
			 
		}
		
	}

	private static void selectCustomize(Connection con2, String url, String username, String password) throws SQLException 
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter department name?");
		String sql="select * from employeee where dept=?";
		PreparedStatement stat2 = con2.prepareStatement(sql);
		String a=sc.nextLine();
		stat2.setString(1, a);
        ResultSet execute = stat2.executeQuery();	
        System.out.println("-------------------------------------------------------");
	      System.out.printf("|%-3s | %-7s | %-17s | %-5s  | %-6s |\n " ,"id","name","email","salary","dept");
	      
	     while(execute.next())
	     {
	    	 int id=execute.getInt("id");
	    	 String name = execute.getString("name");
	    	String email = execute.getString("email");
	    	String salary = execute.getString("salary");
	    	String dept= execute.getString("dept");
	    	System.out.println("-----------------------------------------------------");
	    	System.out.printf("|%-3d | %-7s | %-17s | %-5s  | %-7s |\n " ,id,name,email,salary,dept);
	     }
	     System.out.println("-------------------------------------------------------");
		
	    	
		
	}

	private static void dept(Connection con2, String url, String username, String password) throws SQLException {
		// TODO Auto-generated method stub

		String sql="select dept from employeee";
		Statement stat = con2.createStatement();
		ResultSet res = stat.executeQuery(sql);
		System.out.println(" ---------");
		System.out.println("|   dept  |");
		System.out.println(" ---------");
		
		while(res.next())
		{
			String dept=res.getString("dept");
			System.out.printf("| %-7s |\n", dept);
		}
		System.out.println(" ---------");
		content();
		
	}

	private static void salary(Connection con2, String url, String username, String password) throws SQLException
	{
		String sql="select salary from employeee";
		Statement stat = con2.createStatement();
		ResultSet res = stat.executeQuery(sql);
		System.out.println(" ---------");
		System.out.println("| salary  |");
		System.out.println(" ---------");
		
		while(res.next())
		{
			String salary=res.getString("salary");
			System.out.printf("| %-7s |\n", salary);
		}
		System.out.println(" ---------");
		content();
		
		
	}

	private static void email(Connection con2, String url, String username, String password) throws SQLException 
	{
		String sql="select email from employeee";
		Statement stat = con2.createStatement();
		ResultSet res = stat.executeQuery(sql);
		System.out.println(" -------------------");
		System.out.println("|       email       |");
		System.out.println(" -------------------");
		
		while(res.next())
		{
			String email=res.getString("email");
			System.out.printf("| %-17s |\n", email);
		}
		System.out.println(" -------------------");
		content();
		
		
	}

	private static void name(Connection con2, String url, String username, String password) throws SQLException 
	{
		String sql="select name from employeee";
		Statement stat = con2.createStatement();
		ResultSet res = stat.executeQuery(sql);
		System.out.println(" ---------");
		System.out.println("|  name   |");
		System.out.println(" ---------");
		
		while(res.next())
		{
			String name=res.getString("name");
			System.out.printf("| %-7s |\n", name);
		}
		System.out.println(" --------");
		content();
		
		
		
		
	}

	private static int  content() {
		Scanner sc=new Scanner(System.in);
         System.out.println("which one you retrive data form table ?");
		
		System.out.println("1.Id");
		System.out.println("2.name");
		System.out.println("3.email");
		System.out.println("4.salary");
		System.out.println("5.dept");
		System.out.println("6.display The table");
		System.out.println("7.select Customise Display.");
		System.out.println("8.exit");
		int c=sc.nextInt();
		return c;
		
	}

	private static void id(Connection con2, String url, String username, String password) throws SQLException 
	{
		String sql="select id from employeee";
		Statement stat = con2.createStatement();
		ResultSet res = stat.executeQuery(sql);

		display1(res);
		
	}

	public static void insert(Connection con, String url, String username, String password) throws SQLException
	{
		 Scanner sc = new Scanner(System.in);
		 String sql="insert into `employeee`(`id`,`name`,`email`,`salary`,`dept`) values(?,?,?,?,?)";
		
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
			 //Jdbcclasses.display(conn, null, null);
			 int n = select();
			 UserCustomize(n,con,url,username,password);
			 
			 
			 
			 
		 
	}
	

				 
				 
			 
			

	private static int select() {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("please choose your option ?");
	   System.out.println("1.Insert");
	   System.out.println("2.Select");
	   System.out.println("3.Delete");
	   System.out.println("4.Update");
	   System.out.println("5.exit");
	   int input=sc.nextInt();
	   return input;
	   
		
	}
	public static void display1(ResultSet res ) throws SQLException
	{
		System.out.println(" -----");
		System.out.println("| id  |");
		System.out.println(" -----");
		
		while(res.next())
		{
			int id=res.getInt("id");
			System.out.printf("| %d |\n", id);
		}
		System.out.println(" -----");
		content();
		
		
	}
}
