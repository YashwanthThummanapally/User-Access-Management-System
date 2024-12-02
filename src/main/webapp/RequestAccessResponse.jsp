<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.naresh.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee operations</title>
</head>
<body>
	<%
	UserBean user = (UserBean)session.getAttribute("user");
	String msg = (String)request.getAttribute("msg");
	
	out.print("Page belongs to employee "+user.getUsername()+"<br>");
	out.print(msg+"<br>");
	%>
	<a href="requestAccessI">Request Access To S/W</a><br>
	<a href="logout">Logout</a>
</body>
</html>