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

/**
 * Servlet implementation class HelloWorld
 */

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("username");
		String pword = request.getParameter("password");
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

	System.out.println("pass"+pword);
		PrintWriter out = response.getWriter();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/my1stdatabase";
			Connection connection = (Connection) DriverManager.getConnection(url,"root","root123");

		
			PreparedStatement ps = connection.prepareStatement("select * from registration where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pword);

			
			ResultSet rs = ps.executeQuery();
		//	java.sql.ResultSetMetaData rsmd = rs.getMetaData();

			boolean flag = false;

			while (rs.next()) 
			{

				if (uname.equals(rs.getString(12)) && pword.equals(rs.getString(13))) {
					response.sendRedirect("view.html");

					flag = true;

				}
			}
			if (!flag) {

				out.print("<center><h1>Please Check your Username or Password</h1></center>");
			}

		} catch (Exception e2)

		{

			e2.printStackTrace();

		}
	}

}
