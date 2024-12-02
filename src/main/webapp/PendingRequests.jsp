<%@page import="com.naresh.dao.FetchSoftwareDAO"%>
<%@page import="com.naresh.dao.FetchSoftwaresDAO"%>
<%@page import="com.naresh.dao.FetchEmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.naresh.bean.UserBean, com.naresh.bean.RequestBean, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request List</title>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	List<RequestBean> requests = (List<RequestBean>) request.getAttribute("requests");
	
	out.print("Page belongs to manager "+user.getUsername()+"<br><br>");	
	if(requests.size()==0){
		out.print("No records to display!<br>");
	}else{
	%>
	<table>
		<tr>
			<th>Employee Name</th>
			<th>Software Name</th>
			<th>Access Type</th>
			<th>Reason For Request</th>
		</tr>
		<%
			for(RequestBean requestB : requests) {	
		%>
		<tr>
			<td><%=new FetchEmployeeDAO().getEmployee(requestB.getUserId()) %></td>
			<td><%=new FetchSoftwareDAO().getSoftwareName(requestB.getSoftwareId()) %></td>
			<td><%=requestB.getAccessType() %></td>
			<td><%=requestB.getReason() %></td>
			<td><a
				href="pendingRequests?id=<%=requestB.getRequestId() %>&status=APPROVED">approve</a></td>
			<td><a
				href="pendingRequests?id=<%=requestB.getRequestId() %>&status=REJECTED">reject</a></td>
			<%} %>
		</tr>
	</table>
	<%} %>
</body>
</html>