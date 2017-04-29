package com.controller.LoginPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class DeleteAccount
 */

public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uname = request.getParameter("accusername");
		String pword = request.getParameter("accpassword");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

	
		PrintWriter out = response.getWriter();
		

		try 
		{
			boolean flag=false;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/my1stdatabase";
			Connection connection = (Connection) DriverManager.getConnection(url, "root", "root123");
			String sql="select * from registration where username =? and password=?";
			PreparedStatement pstate=connection.prepareStatement(sql);
			pstate.setString(1, uname);
			pstate.setString(2, pword);
			ResultSet rs=pstate.executeQuery();
			while(rs.next())
			{
				if(uname.equals(rs.getString(12)) && pword.equals(rs.getString(13)))
				{
			String sql1="delete from registration where username =? and password=?";
			
			PreparedStatement pstatement=connection.prepareStatement(sql1);
			pstatement.setString(1, uname);
			pstatement.setString(2, pword);
			pstatement.executeUpdate();
			
			out.print("<center><h1>Delete successful</h1></center>");
			flag=true;
			return;
				}
				
				
		
			}
			if(flag==false)
			{
				out.println("<center><h1>Your Username or Password are incorrect</h1></center>");
				
			}
		
						
				
			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
}
