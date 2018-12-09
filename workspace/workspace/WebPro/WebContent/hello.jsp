<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${param.loc}"/>
<fmt:setBundle basename="msgs"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key = "title"/></title>
</head>
<body>

<h1><fmt:message key="greet"/></h1><hr>
<h2><fmt:message key="msg"/></h2>
<%! int counter = 1000; %>
<h2><fmt:message key="visit"/> <%= ++ counter %></h2>
<% Date at = new Date(); %>
<h2> <fmt:message key="time"/> <%= at %></h2>

<a href="hello.jsp?loc=en">English</a> | 
<a href="hello.jsp?loc=hi">Hindi</a> |
<a href="hello.jsp?loc=fr">French</a> |
<a href="hello.jsp?loc=es">Spanish</a> 
</body>
</html>