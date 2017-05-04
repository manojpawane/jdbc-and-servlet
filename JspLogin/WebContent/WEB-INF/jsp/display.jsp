<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="display">
<table>
<tr>
<td>Enter Name</td>
<td>input type=text name=textn size="10"></td> 
</tr>

<tr><td colspan="2"><center><input type="submit" value="Submit" ></center></td></tr>

</table>

<%
Connection connection=null;
String name=request.getParameter("textn");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	 connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/my1stdatabase", "root", "root123");
	PreparedStatement ps = connection.prepareStatement("select * from registration where name=?");
	//request.getRequestDispacher("EmployeeDisplay.jsp").include(request,response);
	
}
catch (Exception e2)
{
out.print("Unable to COnnect to Database");

}








%>






</form>>
</body>
</html>