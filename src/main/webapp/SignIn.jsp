<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body style="background-color: #dfb5f5; display: flex; justify-content: center; align-items: center; height: 100vh;">
	<div style="text-align:center; ">
	<form action="SignIn" method="post">
	  		<label style="display: inline-block; width: 100px; text-align: right;  font-weight: bold; font-size: 20px;">Email</label>
	  		<input type="text" name="email" style="padding: 8px 10px; border-radius: 5px; border:none; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);">
	  		<br><br>
	  		<label style="display: inline-block; width: 100px; text-align: right;  font-weight: bold; font-size: 20px;">Password</label>
	  		<input type="text" name="password" style="padding: 8px 10px; border-radius: 5px; border:none; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);">
	  		<br><br>
	  		<input type="submit" value="Login"style="padding: 10px 10px; font-weight: bold; border-radius: 20px; border:none; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3); cursor: pointer;">
	</form>
	</div>	
</body>
</html>
