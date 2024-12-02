<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.naresh.bean.SoftwareBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Form</title>
</head>
<body>
	<%
	List<SoftwareBean> softwares = (ArrayList<SoftwareBean>) request.getAttribute("softwares");
	%>
	<form action="requestAccess" method="post">
		Software Name : 
		<select name="swname">
			<%
				for(SoftwareBean software : softwares){
			%>
			<option value='<%=software.getSoftwareName()%>'><%=software.getSoftwareName()%></option>
			<%
				}
			%>
		</select><br>
		Access Type :
		<select name="accessType">
			<option value="READ">Read</option>
			<option value="WRITE">Write</option>
			<option value="ADMIN">Admin</option>
		</select><br>
		Reason For Request : <textarea rows="5" cols="50" name="reason"></textarea><br>
		<input type="submit" value="Request Access">
	</form>	
</body>
</html>