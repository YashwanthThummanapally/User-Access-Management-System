<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.naresh.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager operations</title>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	out.print("Welcome manager "+user.getUsername()+"<br>");
	%>
	<a href="pendingRequestsI">View Pending Requests</a><br>
	<a href="logout">Logout</a>
</body>
</html>