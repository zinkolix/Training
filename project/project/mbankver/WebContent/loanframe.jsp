<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Loan Customer</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<br>
	<br>
	<table>
		<tr id="nav">
			<td>
			<a href="partpayment.jsp" target="myFrame">Part Payment</a><br> <br><hr>
			<a href="foreclosure.jsp" target="myFrame">Fore Closure</a> <br><br><hr>
			<a href="loancust/printstatment.do?view=html" target="myFrame">Statement</a><br><br><hr>
		</td>
			<td><iframe name="myFrame" width="1200" height="400" style="border: none"></iframe></td>
		</tr>

	</table>
	<div class="footer">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>