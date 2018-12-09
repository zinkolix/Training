<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Registration</title>
</head>
<body>
<%@ include file="Banner.html" %>
<hr size=2 color="chocolate">
<h1 align = "center"></h1>
	<br>

	<div align="Right">
		<form action="User.do" method="post">
			<div align="Right" style="width: 300px;">
				<fieldset style="border-style:ridge; border-color: red">
				<legend style="color: white"> Details </legend>
				<table>
					<div align="right">
						Name: <input type="text" name="Name" placeholder="Name" pattern="[A-Za-z]{6,}" required><br><br>
						Username: <input type="text" name="userid" placeholder="Name"  required><br>
						<br> Password: <input type="password" name="password" placeholder="Password" required><br> <br>
						Date of Birth:  <input type="date" name="birthdate" placeholder="mm/dd/yyyy"><br> <br>
						 Email:<input type="email" name="email" placeholder="Email-Id" ><br>
						<br> Phone Number: <input type="text" name="phone" placeholder="eg. 9876543210"><br> <br> 
						
						City: <select name = "city">
  							<option value="Bangalore">Bangalore</option>
  							<option value="Mangalore">Mangalore</option>
 							<option value="Mysore">Mysore</option>
  							<option value="Tumkur">Tumkur</option>
						</select><br><br>
						<input type="submit" value="Register">
					</div>
					
				</fieldset>
			</div>
		</form>
	</div>
	<footer>
	&copy; Copyright 2018 Market.com
	</footer>
</body>
</html>