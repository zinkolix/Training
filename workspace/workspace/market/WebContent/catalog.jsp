<%@page import="com.market.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Catalog</title>
</head>

<body>
<jsp:include page="Banner.jsp" />
	
	<h1>Product Catalog</h1>
	<%
		List<ProductBean> catalog = (List) request.getAttribute("CATALOG");
	%>
	<div class="catalog"
		style="overflow: auto; color: white; padding-left: 18px;"
		align="right">
		<table>
			<%
				for (ProductBean product : catalog) {
			%>

			<tr>
				<td><a href="Shopping.do?code=<%=product.getCode()%>"> <img
						src="images/icon.png" height="40" width="40"
						style="background: none"></a></td>
				<td>#<%=product.getCode()%> <%=product.getDescription()%><br>
					Price: <%=product.getPrice()%><br> Stock Left: <%=product.getStock()%>
					only
				</td>
				<td><div align="right">
						<img src="<%=product.getImage()%>" height="150" width="150">
					</div></td>
			</tr>




			<%
				}
			%>
		</table>
	</div>
	<footer>
	&copy; Copyright 2018 Market.com
	</footer>

</body>
</html>