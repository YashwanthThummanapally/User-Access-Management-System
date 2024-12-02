<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<%
	String msg = (String)request.getAttribute("msg");
	out.print(msg);
	%>
	<%@include file="home.html"%>
</body>
</html>