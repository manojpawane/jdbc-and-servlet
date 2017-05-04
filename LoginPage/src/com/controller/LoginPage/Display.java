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

import com.mysql.jdbc.ResultSetMetaData;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name"); 
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			 String url="jdbc:mysql://localhost:3306/my1stdatabase";
			Connection connection=(Connection)DriverManager.getConnection(url,"root","root123");
			 PreparedStatement ps=connection.prepareStatement("select * from registration where name=?");
			 ps.setString(1, name);
		     

           
                   
             ResultSet rs=ps.executeQuery();    
             
             

            

             java.sql.ResultSetMetaData rsmd=rs.getMetaData();

             while(rs.next())

                {
            	 
            	 out.print("<body bgcolor=orange><table width=25% align=center bgcolor=yellow border=1 ></body>");
            	  out.print("<center><h1>Result:</h1></center>");
             out.print("<tr>");

             out.print("<td>"+rsmd.getColumnName(1)+"</td>");

                out.print("<td>"+rs.getString(1)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");

                out.print("<td>"+rs.getString(2)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");

                out.print("<td>"+rs.getString(3)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");

                out.print("<td>"+rs.getString(4)+"</td></tr>");  
                
                out.print("<td>"+rsmd.getColumnName(5)+"</td>");

                out.print("<td>"+rs.getString(5)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");

                out.print("<td>"+rs.getString(6)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(7)+"</td>");

                out.print("<td>"+rs.getString(7)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(8)+"</td>");

                out.print("<td>"+rs.getString(8)+"</td></tr>");                  

                out.print("<td>"+rsmd.getColumnName(9)+"</td>");

                out.print("<td>"+rs.getString(9)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(10)+"</td>");

                out.print("<td>"+rs.getString(10)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(11)+"</td>");

                out.print("<td>"+rs.getString(11)+"</td></tr>");

                out.print("<tr><td>"+rsmd.getColumnName(12)+"</td>");

                out.print("<td>"+rs.getString(12)+"</td></tr>");                  
                out.print("</table>");

             }

            



      }catch (Exception e2)

        {

            e2.printStackTrace();

        }



      finally{out.close();
		}
		
	}

	
	
	

}
