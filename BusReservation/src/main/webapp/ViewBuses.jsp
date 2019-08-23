<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.BusDetails,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["bus_id"].value;



		document.getElementById('enter').innerHTML = "";


		if (username == null || username == "") {

			document.getElementById('enter').innerHTML += "<p>Enter Bus_Id</p>";

			return false;
		} 
		return true;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="D3D3D3">
			<%
		ArrayList<BusDetails> viewBuses = (ArrayList<BusDetails>) session.getAttribute("viewBuses");
			
	%>	
			<% if(viewBuses.size()!=0){ %>
			<form align="center" action="BeginReservation" method="POST" onsubmit="return display();" name="form">
		<table border="1" align="center">
		<thead>
		<tr>
		<th>BUS_ID</th>
		<th>BUS_TYPE</th>
		<th>AVAILABLE SEATS</th>
		<th>FARE</th>
		</tr>
		</thead>
		<tr>	<%
			for (BusDetails viewBus : viewBuses) {
				out.print("<tr><td>"+viewBus.getBus_id()+"</td>"+"<td>"+viewBus.getBus_type()+"</td>"+"<td>"+viewBus.getAvailable_seats()+"</td>"+"<td>"+viewBus.getFare()+"</td>");
			}
			%>
			</tr>
		</table>
		<br><br>
		Enter the Bus Id:<input type="number" name="bus_id"><input type="submit">
		<p id="enter">
		</form>
		<%}
			else{
				out.println("<h3 align=\"center\">No Buses Available</h3>");
				out.println("<a align=\"center\" href=\"User.jsp\"><input type=\"button\" value=\"Back\"></a>");
			}
			%>

</body>
</html>