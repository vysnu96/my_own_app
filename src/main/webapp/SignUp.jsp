<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<form action="SignUp" method="post">
			<label>First Name</label>
	  		<input type="text" name="firstname">
	  		<br><br>
	  		<label>Last Name</label>
	  		<input type="text" name="lastname">
	  		<br><br>
	  		<label>Email</label>
	  		<input type="text" name="email">
	  		<br><br>
	  		<label>Password</label>
	  		<input type="text" name="password">
	  		<br><br>
	  		<input type="submit" value="submit">
	</form>
</body>
</html>