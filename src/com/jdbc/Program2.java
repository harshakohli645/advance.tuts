package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {
	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Kohlianu@645";
		String sql="update employeee set salary=salary+10000";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement smt = con.createStatement();
		int i = smt.executeUpdate(sql);
		Jdbcclasses.display(con, smt, null);
	}

}
