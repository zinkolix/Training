<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Login</title>
</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>
<h2></h2>
	
	<br>
	<div align="Right">
		<form>
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Login Details </legend>
					Id: <input type="text" name="Id" placeholder="Id" required><br>
					<br> Password: <input type="password" name="password"
						placeholder="Password"  pattern = "[A-Za-z0-9]{8,}" required><br>
					<div align="left">
						<br> <input type="radio" name="type" value="Employee" checked>
						Employee <br> <input type="radio" name="type"
							value="Customer">Customer <br> <br>
							 <input type="submit" value="Login"> <br>
							 <a href="registerframe.jsp">Register</a>
							 
					</div>
				</fieldset>
			</div>
		</form>
	</div>
	<div class="footer">
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>