<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="right">
		<form action="customer/deposit.do" method="post">
			<div align="Right" style="width: 400px">
				<fieldset style="border-color: red">
					<legend> Deposit </legend>
					<div align="left">
						Amount: <br> <input type="number" name="amount"
							placeholder="Amount" min="100"> <br> <br> <input
							type="submit" value="Deposit"> <br>
						<font style="color: red">
<%
 	String success = (String) request.getAttribute("success");
 %>
							<%
								if (success != null) {
							%> <%=success%> <%
 	}
 %> <%
 	String fail = (String) request.getAttribute("fail");
 %>
							<%
								if (fail != null) {
							%> <%=fail%> <%
 	}
 %> <%
 	String error = (String) request.getAttribute("error");
 %>
							<%
								if (error != null) {
							%> <%=error%> <%
 	}
 %>
					</div>
				</fieldset>
			</div>
		</form>
	</div>

</body>
</html>