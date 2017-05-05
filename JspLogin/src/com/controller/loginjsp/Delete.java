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

import com.mysql.jdbc.Statement;


@WebServlet("/Delete")

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uname = request.getParameter("accusername");
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

	
		PrintWriter out = response.getWriter();
		

		try 
		{
			boolean flag=false;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/my1stdatabase";
			Connection connection = (Connection) DriverManager.getConnection(url, "root", "root123");
			String sql="select * from emp_registration where name =?";
			PreparedStatement pstate=connection.prepareStatement(sql);
			pstate.setString(1, uname);

			ResultSet rs=pstate.executeQuery();
			while(rs.next())
			{
				if(uname.equals(rs.getString(1)))
				{
			String sql1="delete from emp_registration where name=?";
			
			PreparedStatement pstatement=connection.prepareStatement(sql1);
			pstatement.setString(1, uname);
	
			pstatement.executeUpdate();
			
			out.print("<center><h1>Delete successful</h1></center>");
			request.getRequestDispatcher("view.jsp").forward(request, response);
			flag=true;
			return;
				}
				
				
		
			}
			if(flag==false)
			{
				
				
				request.getRequestDispatcher("view.jsp").forward(request, response);
				out.println("<center><h1>Name is incorrect</h1></center>");
			}
		
						
				
			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
}
