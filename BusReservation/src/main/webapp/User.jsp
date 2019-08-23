<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["noofseats"].value;

		var idproof = document.forms["form"]["dateofjourney"].value;

		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";

		if (username == null || username == "") {

			document.getElementById('enter').innerHTML += "<p>Enter No-Of-Seats</p>";

			return false;
		} else if (idproof == null || idproof == "") {

			document.getElementById('enter1').innerHTML += "<p>Enter Date</p>";

			return false;
		}
		return true;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="D3D3D3">
			<%@ include file="Welcome.jsp"%>
			<hr>
	<br>
	<br>
	<%
		ArrayList<String> sources = (ArrayList<String>) request.getAttribute("sources");
	ArrayList<String> destinations = (ArrayList<String>) request.getAttribute("destination");
	%>



	<form action="AvailableBusesList" method="post" onsubmit="return display();" name="form">
		<table align="center">
			<tr>
				<td>select the source:</td>
				<td><select name="source">

						<%
							for (String source: sources) {
						%>
						<option>
							<%=source%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Enter the destination:</td>
				<td><select name="destination">

						<%
							for (String destination: destinations) {
						%>
						<option>
							<%=destination%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>


			<tr>
				<td>No of seats(min 1 and max 4)</td>
				<td><input type="number" min="1" and max="4" name="noofseats"></td>
				<p id="enter">
			</tr>
			<tr>
				<td>Date of journey:</td>
				<td><input type="date" name="dateofjourney"
					></td>
					<p id="enter1">
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
			

</body>
</html>