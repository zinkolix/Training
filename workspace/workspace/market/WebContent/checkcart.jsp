<%@page import="com.market.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>ChecKCart</title>
</head>
<body>
<header>
<jsp:include page="Banner.jsp" />
</header>
<% List<ProductBean> cart = (List)session.getAttribute("CART"); %>
<% if(request.getParameter("idx") != null){
	cart.remove(Integer.parseInt(request.getParameter("idx")));
	session.setAttribute("CART", cart);
	
}%>
<div align="right">
<table>
<tr>
<th> <b>Your shopping cart </b></th>
</tr>
<% double total = 0; %>
<td>
<%	for(int i = 0; i<cart.size();i ++){
		ProductBean product = cart.get(i);%>
	 <br>
	 <img  src="<%= product.getImage()%>" height = "200" width= "200">
	<br>
	<%= product.getDescription() %><br>
	Rs. <%=product.getPrice() %>
		<br>
		
		 <a href="checkcart.jsp?idx=<%=i %>">Remove item</a>
		</td>
		<%total = total + product.getPrice(); %>
<% }%>

</table><br>
<div style="color: white">
Total= <%= total %>
</div>
<div class ="footer1">
	&copy; Copyright 2018 Market.com
	 <a style="padding-left: 60px; color: red" href="Shopping.do">Back to Catalog</a>
	</div>
</body>
</html>