<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Colors</title>
</head>
<body>

	<form method="post">
		<input type="text" name="color"><br>
		<input type="submit" value="Submit">
	</form>
	
	<p>Session: ${sessionId}</p>
	<p>Colors: ${favoriteColors}</p>

</body>
</html>