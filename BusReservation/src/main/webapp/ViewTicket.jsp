<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["pnr"].value;



		document.getElementById('enter').innerHTML = "";


		if (username == null || username == "") {

			document.getElementById('enter').innerHTML += "<p>Enter Pnr</p>";

			return false;
		} 
		return true;
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<br>
	<br>
	<br>
		<form action="ViewTicket" align="center" method="post" onsubmit="return display();" name="form">
			<table align="center">
				<tr>
					<td>Enter the PNR No:</td>
					<td><input type="number" name="pnr"></td>
					<p id="enter">
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>

</body>
</html>