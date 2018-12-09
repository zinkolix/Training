<%@page import="com.mphasis.bankweb.entity.Employee"%>
<%@page import="com.mphasis.bankweb.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String name = null;
	Object user = session.getAttribute("user");
	if(user instanceof Customer){
		Customer cust = (Customer)user;
		name = cust.getCustName();
	}else {
		Employee emp = (Employee) user;
		name = emp.getEmpName();
} %>
<div style="background-image :url(images/banner.jpg); background-size:inherit; color:whitesmoke; padding-top: 10px; padding-left: 50px; padding-bottom: 10px; font-size: 200%; align-content: center" >
       M Bank 
    </div>
 <div style="padding-left: 1100px">Hello,  <%= name %> | <a href = "logout.do">logout</a></div> 
</body>
</html>