package com.controller.loginjsp;

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

@WebServlet("/Userregister")
public class Userregister extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String txtname = request.getParameter("name");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		String pass = request.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/my1stdatabase", "root", "root123");
			System.out.println("Connected");
			String query = "insert into user values(?,?,?,?)";
			PreparedStatement pstatement = (PreparedStatement) connection.prepareStatement(query);

			pstatement.setString(1, txtname);
			pstatement.setString(2, email);
			pstatement.setString(3, pass);
			pstatement.setString(4, mob);

			int i = pstatement.executeUpdate();
			if (i > 0)
				out.print("You are successfully registered...");

		} catch (Exception e2) {
			System.out.println(e2);
		}
		{

			out.close();
		}

	}

}
