<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.Login"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="STARTFROMHERE.jsp"%>
	<br>
	<br>
	<% Login validate=(Login)request.getAttribute("validate"); %>
	<%if(validate!=null){ %>
	<a href="Income.jsp">View income Of Buses</a>
	<br>
	<br>
	<a href="NoOfBuses.jsp">View Total No of buses</a>
	<br>
	<br>
	<a href="NoOfPassengers.jsp">View No of Passengers</a>
	<br>
	<br>
	<%}%>
	<%if(validate==null) { %>
	<h3>Enter valid credentials</h3>
	<a align="center" href="Login.jsp"><input type="button" value="Back"></a>
	<%}%>
</body>
</html>