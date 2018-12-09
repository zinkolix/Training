<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Home</title>

</head>
<body>

<jsp:include page="Banner.jsp" />
<h2>Home</h2>
	
	<br>
	<div align="Right">
	<% if(request.getParameter("invalid") != null){ %>
		
		<div style="color: white">	Invalid UserId/Password!!! </div>
	<% } %>
		<form action="User.do" method="post">
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend style="color: white"> Login Details </legend>
					Username: <input type="text" name="userid" placeholder="User Id"  required><br>
					<br> Password: <input type="password" name="password"
						placeholder="Password"  required><br>
					
						<br> <br> <input
							type="submit" value="Login"><br><br>
							New User
							<a href="Registration.jsp">Register Here</a>
					
				</fieldset>
			</div>
		</form>
	</div>
	<footer>
	&copy; Copyright 2018 Market.com
	</footer>
</body>
</html>