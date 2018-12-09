<%@page import="com.market.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Summary</title>
</head>
<body>
<jsp:include page="Banner.jsp" />
<%ProductBean product = (ProductBean)request.getAttribute("PRODUCT"); %>
<table>
<tr><th> Product Summary  </th></tr>
<tr>
<td> <img src="<%= product.getImage() %>"height = "200" width= "200"></td>
<td> Product Added to cart </td>
<%= product.getDescription() %><br>

Rs.<%= product.getPrice() %>
</tr>
<tr>
<th> <a href="Shopping.do">Continue shopping</a>
<th> <a href="checkcart.jsp">Check Out</a>
</tr>
</table>
<footer>
	&copy; Copyright 2018 Market.com
	</footer>
</body>
</html>