<%@page import="com.mphasis.bankweb.entity.LoanCustomer"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><% List<LoanCustomer> loancust=(List) request.getAttribute("customers"); %></h1>
<table align="center" width="100%" border="1" cellspacing="5">
<tr bgcolor="wheat">
<th>Customer Id</th><th>Name</th><th>PAN</th><th>Outstanding</th><th>Principle</th><th>Status</th>
</tr>
<% for(LoanCustomer customer :loancust) { %>
<tr bgcolor="white" align="center" style="font-family:sans-serif;font-size:16;letter-spacing: 1" >
<td><%= customer.getCustId() %></td>
<%-- <td><%= customer.getAcnt().getAcntId()%></td> --%>
<td><%= customer.getCustName() %></td>
<td><%= customer.getPan() %></td>
<td><%= customer.getAcnt().getOutstanding() %></td>
<td><%= customer.getAcnt().getPrinciple() %></td>
<td><%= customer.getStatus() %></td>
</tr>

<% } %>

</body>
</html>