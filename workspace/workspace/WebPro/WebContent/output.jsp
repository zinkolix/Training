<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ouput</title>
</head>
<body>
<jsp:useBean id="pers" class="com.mphasis.bean.Person" scope="request"/>
Name: ${pers.name } <br>
Age: <jsp:getProperty property="age" name="pers"/>
City: <jsp:getProperty property="city" name="pers"/>
</body>
</html>