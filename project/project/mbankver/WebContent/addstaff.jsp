<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="theme.css">
<title>Add Staff</title>
</head>
<body>

	<div align="Right">
		<form action="manager/add.do" method="post">
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Details</legend>
					<div align="left">
						Name:<br> <input type="text" name="name" placeholder="Name"
							pattern="[A-Za-z]{4,}" required><br> <br>
						<br> Pan:<br>
						<input type="text" name="pan" placeholder="eg. ABCD1234"
							pattern="[A-Za-z]{4}[0-9]{4,}" required><br>
						Department<input type="radio" name="deptId" value="dept01" checked>
						Deposit <br> <input type="radio" name="deptId" value="dept02">Loan
						<br> <br> <input type="submit" value="Add Staff"> <br>
						<font style="color: red"> <%
 	String error = (String) request.getAttribute("error");
 %>
							<%
								if (error != null) {
							%> <%=error%> <%
 	}
 %>
 <%
 	String id = (String) request.getAttribute("id");
 %>
							<%
								if (id != null) {
							%> <%=id%> <%
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
 %></font><br>
					</div>
				</fieldset>
			</div>
		</form>
	</div>

</body>
</html>