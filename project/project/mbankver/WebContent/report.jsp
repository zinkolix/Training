<%@page import="com.mphasis.bankweb.entity.DepositCustomer"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Report</title>
</head>
<body>
<h1><% List<DepositCustomer> depcust=(List) request.getAttribute("customers"); %></h1>
<table align="center" width="100%" border="1" cellspacing="5">
<tr bgcolor="wheat">
<th>Customer Id</th><th>Account Id</th><th>Name</th><th>PAN</th><th>Balance</th><th>Status</th>
</tr>
<% for(DepositCustomer customer :depcust) { %>
<tr bgcolor="white" align="center" style="font-family:sans-serif;font-size:16;letter-spacing: 1" >
<td><%= customer.getCustId() %></td>
<td><%= customer.getAcnt().getAcntId()%></td>
<td><%= customer.getCustName() %></td>
<td><%= customer.getPan() %></td>
<td><%= customer.getAcnt().getBalance() %></td>
<td><%= customer.getStatus() %></td>
</tr>

<% } %>


</table>

</body>
</html>