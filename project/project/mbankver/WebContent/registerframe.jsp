<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Register</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<br>
	<br>
	<table>
		<tr id="nav">
			<td><a href="login.jsp">Home</a> <br> <br><hr>
			<a href="depositcustomer.jsp" target="myFrame">Deposit Account Form</a><br> <br><hr>
			<a href="loancustomer.jsp" target="myFrame">Loan Account Form</a> <br><br><hr>
		</td>
			<td><iframe name="myFrame" width="1200" height="450" style="border: none"></iframe></td>
		</tr>

	</table>
	<div class="footer">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>