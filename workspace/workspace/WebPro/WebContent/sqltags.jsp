<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sql Tags</title>
</head>
<body>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <sql:setDataSource driver = "oracle.jdbc.OracleDriver" var="myds"
	url="jdbc:oracle:thin:@localhost:1521:xe" user = "xchange" password="mphasis"/> --%>
	
	<sql:query var="rs" dataSource="jdbc/myoracle">
	select * from products
	</sql:query>
	
<table>
<c:forEach items="${rs.rows}" var = "row">
<tr><td> ${row.code} </td>
	<td> ${row.description}</td>
	<td> ${row.price}</td>
</tr>
</c:forEach>
</table>
</body>
</html>