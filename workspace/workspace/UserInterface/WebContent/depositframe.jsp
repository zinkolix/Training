<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="theme.css">
<title>Deposit Customer</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<br>
	<br>
	<table>
		<tr id="nav">
			<td><a href="">Home</a> <br> <br><hr>
			<a href="http://localhost:8880/UserInterface/fundtransfer.jsp" target="myFrame">Fund Transfer</a><br> <br><hr>
			<a href="http://localhost:8880/UserInterface/deposit.jsp" target="myFrame">Deposit</a> <br><br><hr>
			<a href="http://localhost:8880/UserInterface/withdraw.jsp" target="myFrame">Withdraw</a> <br><br><hr>
			<a href="http://localhost:8880/UserInterface/statement.jsp" target="myFrame">Statement</a><br><br><hr>
		</td>
			<td><iframe name="myFrame" width="1200" height="400" style="border: none"></iframe></td>
		</tr>

	</table>
	<div class="footer">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>