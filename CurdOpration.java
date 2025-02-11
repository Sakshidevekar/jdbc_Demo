package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CurdOpration {
	
	public void insertdata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		Scanner sc=new Scanner(System.in);
		PreparedStatement ps=c.prepareStatement("insert into vahical values(?,?,?)");
		System.out.println("Enter vehical id ");
		int vehical_id=sc.nextInt();
		ps.setInt(1, vehical_id);
		System.out.println("Enter vehical name");
		String name=sc.next();
		ps.setString(2, name);
		System.out.println("Enter vehical color");
		String color=sc.next();
		ps.setString(3, color);
		ps.executeUpdate();
		System.out.println("data is inserted succesfully");
		
	}
	
	public void updatedata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		Scanner sc=new Scanner(System.in);
			
		PreparedStatement ps=c.prepareStatement("update vahical set name=? ,color=? where vehical_id=?");
		System.out.println("enter vehical_id ");
		int vehical_id=sc.nextInt();
		ps.setInt(2,vehical_id);
		System.out.println("enter  updated name ");
		String name=sc.next();
		ps.setString(1,name);
		ps.setInt(3, vehical_id);
		System.out.println("enter  updated color");
		String color=sc.next();
		
		ps.setString(1,color);
		ps.executeUpdate();
		System.out.println("data is update succesfully");
	}
	
	public void deletedata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		Scanner sc=new Scanner(System.in);
			
		PreparedStatement ps=c.prepareStatement("delete from vahical where vehical_id=?");
		System.out.println("enter vehical_id ");
		int vehical_id=sc.nextInt();
		ps.setInt(1,vehical_id);
		
		ps.executeUpdate();
		System.out.println("data is deleted succesfully");
	}
	public void fetchdataUaePrepare() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		PreparedStatement ps=c.prepareStatement("select*from vahical");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println("id : "+ rs.getInt(1) +" Name: "+ rs.getString(2) +" color:" +rs.getString(3));
		}
		c.close();
	}

	public static void main(String[] args) throws Exception {
		CurdOpration co=new CurdOpration();
		co.insertdata();
		//co.updatedata();
		//co.deletedata();
		//co.fetchdataUaePrepare();
	}

}
