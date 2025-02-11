package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcQ {
	public void insertdata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
		Statement s=c.createStatement();
		s.executeUpdate("insert into student values(10,'Raniket',23)");
		System.out.println("data inserted");
		//c.commit();
		c.close();
		
	}
	
	public void updatedata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
		PreparedStatement ps=c.prepareStatement("update student set name=? where stud_id=?");
		ps.setString(1, "Saki");
		ps.setInt(2, 789);
		ps.executeUpdate();
		System.out.println("data updated");
		c.close();
	}
	
	public void deletedata() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
		Statement s=c.createStatement();
		s.executeUpdate("delete from student where stud_id=6");
		
		System.out.println("data is delete");
		c.close();
		
	}
	public void fetchdata() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select*from student");
		while(rs.next()){
			System.out.println("id : "+ rs.getInt(1) +" Name: "+ rs.getString(2) +" Age:" +rs.getInt(3));
		}
		
		c.close();
	}
	public void fetchdataUaePrepare() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/thekiran?useSSL=false","root","root");
		PreparedStatement ps=c.prepareStatement("select*from student");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println("id : "+ rs.getInt(1) +" Name: "+ rs.getString(2) +" Age:" +rs.getInt(3));
		}
		c.close();
	}
		
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JdbcQ q=new JdbcQ();
		//q.insertdata();
		q.updatedata();
		//q.deletedata();
		//q.fetchdata();
		//q.fetchdataUaePrepare();
	}

}
