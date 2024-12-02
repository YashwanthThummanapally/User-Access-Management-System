<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Software Form</title>
</head>
<body>
	<form action="createSoftware" method="post">
		Software Name : <input type="text" name="swname"><br><br>
		Description : <textarea rows="5" cols="50" name="des"></textarea><br>
		Access Levels : <input type="checkbox" name="access" value="READ">Read
						<input type="checkbox" name="access" value="WRITE">Write
						<input type="checkbox" name="access" value="ADMIN">Admin<br>
		<input type="submit" value="Create Software">				
	</form>
</body>
</html>