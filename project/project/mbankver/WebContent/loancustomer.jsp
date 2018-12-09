<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Loan Customer Form</title>
</head>
<body>

	<div align="Right">
		<form action="loan/add.do" method = "post">
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Form </legend>
					<div align="left">
												<br><font style="color: red">
					<%String error = (String) request.getAttribute("error"); %>
<%if(error != null){ %>
<%= error %>
<%} %>
<%String id = (String) request.getAttribute("id"); %>
<%if(id != null){ %>
<%= id %>
<%} %><br>
		<%String created = (String) request.getAttribute("created"); %>
<%if(created != null){ %>
<%= created %>
<%} %>
		<%String unsuccessful = (String) request.getAttribute("unsuccessful"); %>
<%if(unsuccessful != null){ %>
<%= unsuccessful %>
<%} %></font><br>
<br>

						Name:<br> <input type="text" name="custName" placeholder="Name" pattern="{A-Za-z}{6,}" required><br>
						<br> <br>

						Date of Birth:<br> <input type="date" name="dob"
							placeholder="mm/dd/yyyy" max="2000-01-01" min = "1950-01-01" required><br> <br> Pan:<br>
						<input type="text" name="pan" placeholder="eg. ABCD1234" pattern = "[A-Za-z]{4}[0-9]{4,}"  required> <br>

						<br> Principle:<br> <input type="number"
							name="principle" placeholder="Principle" min="10000" required><br> <br>

						Tenure:<br> <input type="number" name="tenure"
							placeholder="Tenure" min="1" max="5" required><br> <br> 
						Salary:<br> <input type="number" name="salary"
							placeholder="Salary" required>
							
							<input type="submit" value="Add">

					</div>
				</fieldset>
			</div>
		</form>
	</div>

</body>
</html>