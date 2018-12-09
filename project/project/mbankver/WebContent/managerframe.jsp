<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Manager</title>
</head>
<body>
<jsp:include page="banner.jsp" />

	<br>
	<br>
	<table>
		<tr ><td>
			<a href="addstaff.jsp" target="myFrame">Add Staff</a><br> <br><hr>
			<a href="removestaff.jsp" target="myFrame">Remove Staff</a> <br><br><hr>
			<a href="depositcustomer.jsp" target="myFrame">Deposit Account Form</a><br> <br><hr>
			<a href="removecust.jsp" target="myFrame">Remove Deposit Customer Form</a> <br><br><hr>
			<a href="loancustomer.jsp" target="myFrame">Loan Account Form</a> <br><br><hr>
			<a href="removecust.jsp" target="myFrame">Remove Loan Customer Form</a> <br><br><hr>
			<a href="loan/report.do?view=html" target="myFrame">Report Loan</a> <br><br><hr>
			<a href="manager/depositreport.do?view=html" target="myFrame">Report Deposit</a> <br><br><hr>
		</td>
			<td><iframe name="myFrame" width="1050" height="450" style="border: none"></iframe></td>
		</tr>

	</table>
	<div class="footer">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>