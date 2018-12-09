<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="theme.css">
<title>Login Page</title>
</head>
<body>
<div style="background-image :url(images/banner.jpg); background-size:inherit; color:whitesmoke; padding-top: 10px; padding-left: 50px; padding-bottom: 10px; font-size: 200%; align-content: center" >
       M Bank 
    </div>
<f:form action="authenticate.do"  modelAttribute="login">
<table style="padding-left: 120px; padding-top: 110px;">

<tr><td>
User Id : <td> <f:input path="userId"  /> </td> <br/></td></tr>
<tr><td>
Password : <td><f:input path="password" type="password"/> <br/></td>
</td></tr>
<tr><td>
<f:radiobutton path="role" value="Employee" checked="checked"/>
Employee <br> 
<f:radiobutton path="role" value="Customer"/>Customer <br> <br>
</td></tr>
<tr><td>
<input type="submit" value="Login" />
</td></tr>
<tr><td style="color: red">
<%String failed = (String) request.getAttribute("failed"); %>
<%if(failed != null){ %>
<%= failed %>
<%} %>
<%String inactive = (String) request.getAttribute("inactive"); %>
<%if(inactive != null){ %>
<%= inactive %>
<%} %>
</td></tr>
</table>
</f:form>

</body>
</html>
