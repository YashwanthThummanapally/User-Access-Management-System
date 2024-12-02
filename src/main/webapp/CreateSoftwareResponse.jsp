<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.naresh.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Operations</title>
</head>
<body>
	<%
	UserBean user = (UserBean)session.getAttribute("user");
	String msg = (String)request.getAttribute("msg");
	out.print("Page belongs to admin "+user.getUsername()+"<br>");
	out.print(msg+"<br>");
	%>
	<a href="createSoftwareI">Create Software</a><br>
	<a href="requestAccessI">Request Access To S/W</a><br>
	<a href="pendingRequestsI">View Pending Requests</a><br>
	<a href="logout">Logout</a>
</body>
</html>