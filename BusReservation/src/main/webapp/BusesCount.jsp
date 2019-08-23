<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<%@include file="NoOfBuses.jsp" %>
			<br><br>
			<%Integer count=(Integer)request.getAttribute("count"); %>
			<% if(count!=0)
			{%>
				<h3>No of Buses are:<%=count %></h3>
				<% }%>
				
</body>
</html>