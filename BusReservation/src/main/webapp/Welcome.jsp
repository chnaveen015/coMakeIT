<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
marquee {
	width: 100%;
	padding: 10px 0;
	background-color: lightblue;
}
</style>
<body align="center" bgcolor="D3D3D3">
	<form align="center" action="UserServlet" method="post">
		<table
			style="border: 1px solid black; margin-left: auto; margin-right: auto;">
			<thead align="center">
				<tr>
					<th><marquee behavior="scroll" direction="left">
							<h3>Welcome To Online Reservation</h3>
						</marquee></th>
				</tr>
			</thead>
			<tr>
				<td><input type="submit" name="operation" value="ReserveTicket">
					<input type="submit" name="operation" value="CancelTicket">
					<input type="submit" name="operation" value="viewticket"> 
					<a href="STARTFROMHERE.jsp"><input type="button" value="Back"></a>
					
				</td>
			</tr>
		</table>

	</form>
</body>
</html>

