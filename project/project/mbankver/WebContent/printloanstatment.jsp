<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.mphasis.bankweb.entity.LoanTransaction"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%
			Set<LoanTransaction> txn = (Set) request.getAttribute("customers");
		%>
	</h1>
	<table align="center" width="100%" border="1" cellspacing="5">
		<tr bgcolor="wheat">
			<th>Txn Id</th>
			<th>Txn Type</th>
			<th>EMI</th>
			<th>Amount</th>
			<th>OutStanding</th>
		</tr>
		<%
			for (LoanTransaction customer : txn) {
		%>
		<tr bgcolor="white" align="center"
			style="font-family: sans-serif; font-size: 16; letter-spacing: 1">
			<td><%=customer.getTxnId()%></td>
			<td><%=customer.getTxnType()%></td>
			<td><%=customer.getLa().getEmi()%></td>
			<td><%=customer.getAmount()%></td>
			<td><%=customer.getOutstanding()%></td>

		</tr>

		<%
			}
		%>
	
</body>
</html>