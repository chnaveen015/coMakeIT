<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Reservation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Welcome.jsp"%>
	<br>
	<br>
	

	<%
		Reservation ticket = (Reservation) request.getAttribute("ticket");
	%>
	<% if(ticket!=null) { %>
	<h3>Ticket</h3>
	<form align="center">
		<table border="1" align="center">
			<thead>
				<tr>
					<th>PNR</th>
					<th>BUS_ID</th>
					<th>NAME</th>
					<th>ID PROOF NO</th>
					<th>NO OF SEATS</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>Date</th>
					<th>BUS TYPE</th>
					<th>COST</th>
				</tr>
			</thead>


			<tr>
				<%
					out.print("<tr><td>" + ticket.getPnr() + "</td>" + "<td>" + ticket.getBus_id() + "</td><td>"
							+ ticket.getName() + "</td><td>" + ticket.getId_proof_no() + "</td><td>" + ticket.getNo_of_seats()
							+ "</td>" + "<td>" + ticket.getSource() + "</td><td>" + ticket.getDestination() + "</td><td>"
							+ ticket.getDateOfJourney() + "</td><<td>" + ticket.getJourney().getBus().getBus_type() + "<td>"
							+ ticket.getFare() + "</td></tr>");
				%>
			</tr>
		</table>
	</form>
	<%} %>
	<% if(ticket==null){%>
	<h3 align="center"> No Ticket Found</h3>
	<%}%>
</body>
</html>