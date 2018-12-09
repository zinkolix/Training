<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width:100%; font-size: 50px; color: white; font-style: oblique;" align="right" >
	Welcome to Market
	
</div>
<hr size=2 color="chocolate">
<br>

<%String userid = (String)session.getAttribute("USER"); 
	if(userid != null){%>
	
<div style="color: white"> Hello <%=userid %> | <a href= "User.do?logout=yes">Logout</a></div>

<%} %>

</body>
</html>