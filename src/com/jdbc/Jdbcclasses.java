package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcclasses {

	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Kohlianu@645";
		 Connection conn=null;
		 Statement smt=null;
		 ResultSet res=null;
		
		try 
		{
			 conn=DriverManager.getConnection(url,username,password);
			   display(conn,smt,res);
			   close(conn,smt,res);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	  static void close(Connection conn, Statement smt, ResultSet res) throws SQLException {
		   if(conn!=null)
		   {
			   conn.close();
		   }
		   if(smt!=null)
		   {
			   smt.close();
		   }
		   if(res!=null)
		   {
			   res.close();
		   }
		
	}

	static void display(Connection conn, Statement smt, ResultSet execute) {
		 try
		 {
			 smt = conn.createStatement();
		      execute = smt.executeQuery("select * from employeee ");
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
		     System.out.println("-----------------------------------------------------");
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		
	}

}
