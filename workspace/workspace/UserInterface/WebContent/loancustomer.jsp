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
		<form>
			<div align="Right" style="width: 300px">
				<fieldset style="border-color: red">
					<legend> Form </legend>
					<div align="left">

						Name:<br> <input type="text" name="name" placeholder="Name" pattern="{A-Za-z}{6,}" required><br>
						<br> Password:<br> <input type="password"
							name="password" placeholder="Password" required><br> <br>

						Date of Birth:<br> <input type="date" name="date"
							placeholder="mm/dd/yyyy"><br> <br> Pan:<br>
						<input type="text" name="pan" placeholder="eg. ABCD1234" pattern = "[A-Za-z]{4}[0-9]{4,}"  required> <br>

						<br> Principle:<br> <input type="number"
							name="principle" placeholder="Principle" required><br> <br>

						Tenure:<br> <input type="number" name="tenure"
							placeholder="Tenure" required><br> <br> 
							
							
							<input type="submit" value="Add">
					</div>
				</fieldset>
			</div>
		</form>
	</div>

</body>
</html>