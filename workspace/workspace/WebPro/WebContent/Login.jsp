<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login Form</h2>
	<hr size=2 color="chocolate">
	<br>
	<div align="Right">
		<form action="Login.as" method="post">
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Login Details </legend>
					Username: <input type="text" name="username" placeholder="Username" pattern = "[A-Za-z0-9]{8,}" required><br>
					<br> Password: <input type="password" name="password"
						placeholder="Password"  required><br>
					<div align="left">
						<br> <br> <input
							type="submit" value="Login">
					</div>
				</fieldset>
			</div>
		</form>
	</div>
</body>
</html>