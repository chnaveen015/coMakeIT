<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["bus_id"].value;

		var idproof = document.forms["form"]["date"].value;

		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";

		if (username == null || username == "") {

			document.getElementById('enter').innerHTML += "<p>Enter Bus_Id</p>";

			return false;
		} else if (idproof == null || idproof == "") {

			document.getElementById('enter1').innerHTML += "<p>Enter Date</p>";

			return false;
		}
		return true;
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Admin.jsp"%>
	<br>
	<br>
	<br>
		<form action="NoOfPassengersServlet" align="center" onsubmit="return display();" name="form" method="post">
			<table align="center">
				<tr>
					<td>Enter the Bus ID:</td>
					<td><input type="number" name="bus_id"></td>
					<p id='enter'>
				</tr>
				<tr>
					<td>Enter The Date:</td>
					<td><input type="date" name="date"></td>
					<p id='enter1'>
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>

</body>
</html>