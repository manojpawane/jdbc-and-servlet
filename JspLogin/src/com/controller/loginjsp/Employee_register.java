package com.controller.loginjsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Employee_register")

public class Employee_register extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String txtname=request.getParameter("textnames");  
		String mobi=request.getParameter("mobile");
		String comp=request.getParameter("company");
		String agee=request.getParameter("age");
		String genders=request.getParameter("gender");
		String special=request.getParameter("specialized");
		String lang=request.getParameter("language");
		String add=request.getParameter("address");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			 String url="jdbc:mysql://localhost:3306/my1stdatabase";
			Connection connection=(Connection)DriverManager.getConnection(url,"root","root123");
			String query="insert into user values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstatement= (PreparedStatement) connection.prepareStatement(query);
			
			
			pstatement.setString(1, txtname);
			pstatement.setString(8, mobi);
			pstatement.setString(3, comp);
			pstatement.setString(4, agee);
			pstatement.setString(5, genders);
			pstatement.setString(6,special);
			pstatement.setString(2, add);
			pstatement.setString(7, lang);

			
			
			int i=pstatement.executeUpdate();  
			if(i>0)  
			out.print("You are successfully registered...");  
			
			
		}
		catch(Exception e2) {System.out.println(e2);} 
		{
			
			out.close();
		}
		
		
	
		
		
	}

}
