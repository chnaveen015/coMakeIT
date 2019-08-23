<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function display() {
		var pnr = document.forms["form"]["pnr"].value;

		if (pnr == null || pnr == "") {

			alert("enter the pnr");

			return false;
		} 
		return true;
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="CancelTicketServlet" align="center" method="post" onsubmit="return display();" name="form">
		<table align="center">
			<tr>
				<td>Enter the PNR number:</td>
				<td><input type="number" name="pnr"></td>
				<td><input type="submit" name="cancel" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>