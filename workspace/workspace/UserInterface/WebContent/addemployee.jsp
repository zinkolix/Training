<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>New Employee</title>
</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>

	<br>

	<div align="Right">
		<form>
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Employee Details </legend>
					<div align="left">
						Employee Name: <br>
						<input type="text" name="emp_name" placeholder="Employee Name" "[A-Za-z]{6,}" required><br>
						<br> Password: <br> <input type="password"
							name="password" placeholder="Password"  pattern="[A-Za-z0-9]{8,}" required><br>
						<br> Pan: <br>
						<input type="text" name="pan" placeholder="eg. ABCD1234" pattern = "[A-Za-z]{4}[0-9]{4,}"  ><br>
						<br> Department:<br> <select name="emp_type">
							<option value="deposit">Deposit Account </option>
							<option value="loan"> Loan Account </option>
						</select><br>
						<br> <input type="submit" value="Add">
					</div>
				</fieldset>
			</div>
		</form>
	</div>
</body>
</html>