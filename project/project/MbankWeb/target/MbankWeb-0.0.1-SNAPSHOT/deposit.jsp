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
		<form>
			<div align="Right" style="width: 400px">
				<fieldset style="border-color: red">
					<legend> Deposit </legend>
					<div align="left">
						Account No:<br> <input type="text" name="account"
							placeholder="Account Number" pattern = "[SB][LN]{2}[0-9]{5,}" required><br>
						<br> Amount: <br>
						<input type="number" name="amount" placeholder="Amount"> <br>
						<br> <input type="submit" value="Send">
					</div>
				</fieldset>
			</div>
		</form>
	</div>

</body>
</html>