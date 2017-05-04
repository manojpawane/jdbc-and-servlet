package com.controller.loginjsp;

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

import org.apache.catalina.connector.Request;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("email");
		String pword = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("Link.html").include(request, response);
		 boolean flag=false;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/my1stdatabase", "root", "root123");
			PreparedStatement ps = connection.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pword);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if(uname.equals(rs.getString(2)) &&  pword.equals(rs.getString(3)))
				{
					response.sendRedirect("view.jsp");
					flag=true;
				}
				
			}
			if(flag==false)
			{
				out.println("Please check your username and password");
			}
			
			
			
		}
		catch (Exception e2)
		{
			System.out.println(e2);
		}
		
	}



}
