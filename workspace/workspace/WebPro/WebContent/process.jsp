<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql" %>
<jsp:useBean id="pers" class="com.mphasis.bean.Person" scope="request"/>
<jsp:setProperty property="*" name="pers"/>

<%-- <jsp:setProperty property="name" name="pers"/>
<jsp:setProperty property="age" name="pers"/>
<jsp:setProperty property="city" name="pers" param="city"/> --%>

<%--<% response.sendRedirect("output.jsp"); %>--%>

<sql:update dataSource = "jdbc/myoracle">
insert into person values ('${pers.name}',${pers.age},'${pers.city}')
</sql:update>
 <jsp:forward page="output.jsp"/>
</body>
</html>