<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Userregister" method="get">
<table cellpadding="2" width="20%" bgcolor="99FFFF" align="center" cellspacing="2">
<tr>

<td>Name</td>

<td><input type=text name=textnames size="20"></td>

</tr>

<td>Email</td>

<td><input type=text name=email size="20"></td>

</tr>

<td>Password</td>

<td><input type=text name=password size="20"></td>

</tr>
<tr>
<td>Mobile No.</td>
<td>
<input type=text name=mob size="20">

</td>

</tr>
<tr>
<td colspan="2">

<center><input type="reset"><input type="submit" value="Submit" /></center></td>

</tr>

</table>
</form>
</body>
</html>