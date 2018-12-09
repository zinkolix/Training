<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="theme.css">
<title>Deposit Customer</title>
</head>
<body>
	
	<br>
	<div align="Right">
		<form action="deposit/add.do" method="post">
		<br>
	<font style="color: red">  <%
		String id = (String) request.getAttribute("id");
	%>
		<%
			if (id != null) {
		%> <%=id%> <%
 	}
 %><br> <%
 	String error = (String) request.getAttribute("error");
 %>
		<%
			if (error != null) {
		%> <%=error%> <%
 	}
 %> <%
 	String created = (String) request.getAttribute("created");
 %>
		<%
			if (created != null) {
		%> <%=created%> <%
 	}
 %> <%
 	String unsuccessful = (String) request.getAttribute("unsuccessful");
 %>
		<%
			if (unsuccessful != null) {
		%> <%=unsuccessful%> <%
 	}
 %></font>
	<br>
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Details</legend>
					<div align="left">
						Name:<br> <input type="text" name="custName"
							placeholder="Name" pattern="[A-Za-z]{4,}" required><br>
						<br> <br> Date of Birth: <br> <input type="date"
							name="dob" placeholder="mm/dd/yyyy" max="2000-01-01"
							min="1950-01-01" required><br> <br> Pan:<br>
						<input type="text" name="pan" placeholder="eg. ABCD1234"
							pattern="[A-Za-z]{4}[0-9]{4,}" required><br> <br>
						Amount:<br> <input type="number" name="amount"
							placeholder="Amount" min="1000" required><br> <br>
						<input type="submit" value="Add"> <br>
						<font style="color: red">
					</div>
				</fieldset>
			</div>
		</form>
	</div>
</body>
</html>