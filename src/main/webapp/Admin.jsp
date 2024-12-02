<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.naresh.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin operations</title>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	out.print("Welcome admin "+user.getUsername()+"<br>");
	%>
	<a href="createSoftwareI">Create Software</a><br>
	<a href="requestAccessI">Request Access To S/W</a><br>
	<a href="pendingRequestsI">View Pending Requests</a><br>
	<a href="logout">Logout</a>
</body>
</html>