<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function display() {
		var date = document.forms["form"]["date"].value;
		if (date == null || date == "") {

			alert("enter the Date");
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
		<form action="IncomeServlet" align="center">
			<table align="center">
				<tr>
					<td>Enter The Date:</td>
					<td><input type="date"  name="date"></td>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>

</body>
</html>