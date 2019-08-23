<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
marquee {
	width: 100%;
	padding: 10px 0;
	background-color: lightblue;
}
</style>
</head>
<body align="center" bgcolor="D3D3D3">
	<form align="center">
		<table
			style="border: 1px solid black; margin-left: auto; margin-right: auto;">
			<thead align="center">
				<tr>
					<th align="center"><marquee behavior="scroll" direction="left">
							<h3>Welcome To Online Reservation</h3>
						</marquee></th>
				</tr>
			</thead>
			<tr>
				<td><a href="Login.jsp"><input type="button" name="operation" value="Admin"></a>
					<a href="Welcome.jsp"><input type="button" name="operation" value="User"></a></td>
			</tr>
		</table>
		<hr>
	</form>

</body>
</html>