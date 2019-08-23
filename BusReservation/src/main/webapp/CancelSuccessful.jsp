<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%String status=(String)request.getAttribute("status");		
		%>
		<%if(status.equals("yes"))
			{%>
			<h3 align="center">Cancelled Successfully!</h3>
			<a align="center" href="Welcome.jsp" ><input type="button" value="Back"></a>
			<%} %>
			<% if(status.equals("no")){ %>
			<h3 align="center"> Failed To Cancel!</h3>
			<a align="center" href="Welcome.jsp" ><input type="button" value="Back"></a>
			<%} %>

</body>
</html>