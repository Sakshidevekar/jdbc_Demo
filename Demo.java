package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {

		public static void main(String[] args){
			try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection c=DriverManager.getConnection("jdbc:mysql://localHost:3306/thekiran?useSSL=false","root","root");
	          Statement s=c.createStatement();
	          s.executeUpdate("insert into student values(4,'Anit',65)");
	          System.out.println("data is inserted Successfully");
	          c.close();
	          s.close();
		}catch ( Exception e) {
			e.printStackTrace();
		}
			
		}
		}


		


