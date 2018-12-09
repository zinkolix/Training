<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Remove Staff</title>
</head>
<body>
	<div align="Right">
		<form action="manager/remove.do" method = "post">
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Details</legend>
					<div align="left">
						Employee Id:<br> <input type="text" name="empId" placeholder="Employee Id" " required><br>
						<br> <br>
						 <br> <input
							type="submit" value="Remove"><br>
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
 %></font>
					</div>
				</fieldset>
			</div>
		</form>
	</div>

</body>
</html>