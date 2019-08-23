<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,repository.BusDao"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["startingDate"].value;

		var idproof = document.forms["form"]["endingDate"].value;


		if (username == null || username == "") {

				alert("enter starting date");

			return false;
		} else if (idproof == null || idproof == "") {

			alert("enter endingDate");
			return false;
		}
		return true;
	}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%@ include file="STARTFROMHERE.jsp"%>
	<hr>
	<br>
	<br>
	<%
	ArrayList<String> sources = new BusDao().getSources();
	ArrayList<String> destinations = new BusDao().getDestinations();

	%>



	<form action="NoOfBusesServlet" method="post" onsubmit="return display();" name="form">
		<table align="center">
			<tr>
				<td>select the source:</td>
				<td><select name="sources">

						<%
							for (String s : sources) {
						%>
						<option>
							<%=s%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Enter the destination:</td>
				<td><select name="destinations">

						<%
							for (String d : destinations) {
						%>
						<option>
							<%=d%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>
			<tr>
				<td>StartingDate</td>
				<td><input type="date"  name="startingDate"></td>
			</tr>
			<tr>
				<td>EndingDate:</td>
				<td><input type="date" name="endingDate"
					></td>
			</tr>
			<tr>


			<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>