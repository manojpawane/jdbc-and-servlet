package com.controller.LoginPage;

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



public class RegistrationUploadData extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String txtname=request.getParameter("textnames");  
		String fatname=request.getParameter("fathername");  
		String padd=request.getParameter("paddress");  
		String gen=request.getParameter("gender");
		String cour=request.getParameter("course");
		String dist=request.getParameter("district");
		String stat=request.getParameter("state");
		String pinc=request.getParameter("pincode");
		String email=request.getParameter("emailid");
		String db=request.getParameter("dob");
		String mob=request.getParameter("mobileno");
		String unam=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			 String url="jdbc:mysql://localhost:3306/my1stdatabase";
			Connection connection=(Connection)DriverManager.getConnection(url,"root","root123");
			String query="insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstatement= (PreparedStatement) connection.prepareStatement(query);
			
			
			pstatement.setString(1, txtname);
			pstatement.setString(2, fatname);
			pstatement.setString(3, padd);
			pstatement.setString(4, gen);
			pstatement.setString(5, cour);
			pstatement.setString(6, dist);
			pstatement.setString(7, stat);
			pstatement.setString(8, pinc);
			pstatement.setString(9, email);
			pstatement.setString(10, db);
			pstatement.setString(11, mob);
			pstatement.setString(12, unam);
			pstatement.setString(13, pass);
			
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
