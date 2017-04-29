package com.controller.LoginPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		String uname = request.getParameter("accusername");
		String pword = request.getParameter("accpassword");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
	
		PrintWriter out = response.getWriter();
		Connection connection=null;
		PreparedStatement pstatement=null;

		try 
		{
			boolean flag=false;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/my1stdatabase";
			 connection = (Connection) DriverManager.getConnection(url, "root", "root123");
			 String sql = "UPDATE employee set name=? WHERE pword=?"; 
			 pstatement=connection.prepareStatement(sql);
			
			
		    
		      pstatement = connection.prepareStatement(sql);
			 
		      pstatement.setString(1, uname);
		      pstatement.setString(2, pword);
		     pstatement.executeUpdate(); 
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	}
	
	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
