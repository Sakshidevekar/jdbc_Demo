package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo  {

	public static void main(String[] args)   {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
		PreparedStatement ps=c.prepareStatement("update student set name=? where stud_id=?");
		ps.setString(1, "aniket");
		ps.setInt(2, 3);
		ps.executeUpdate();
		
		System.out.println("data is update succesfully");
		c.close();
		ps.close();
		}catch ( Exception e) {
			e.printStackTrace();
		}
		

	}

}
