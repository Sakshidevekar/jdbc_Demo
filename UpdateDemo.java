package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateDemo {
	
	public void createTable() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection  c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		Statement s=c.createStatement();
		s.execute("create table student(id int primary key ,name varchar(40),age int )");
		System.out.println("Table is create succesfully");
		c.close();
	}
	
	public void alterTable() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		Statement s=c.createStatement();
		s.execute("alter table student ADD COLUMN mo_num int");
		System.out.println("Table is alter succesfully");
		c.close();
	}
	public void truncateTable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		Statement s=c.createStatement();
		s.execute("truncate table student ");
		System.out.println("Table is truncate succesfully");
		c.close();
	}
	public void dropTable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata?useSSL=false","root","root");
		Statement s=c.createStatement();
		s.execute("drop table student ");
		System.out.println("Table is drop succesfully");
		c.close();
	}
	

	public static void main(String[] args) throws Exception {
		UpdateDemo ud=new UpdateDemo();
		//ud.createTable();
		//ud.alterTable();
		//ud.truncateTable();
		ud.dropTable();

	}

}
