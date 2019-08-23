<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function display() {
		var username = document.forms["form"]["username"].value;

		var idproof = document.forms["form"]["password"].value;

		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";

		if (username == null || username == "") {

			document.getElementById('enter').innerHTML += "<p>Enter UserName</p>";

			return false;
		} else if (idproof == null || idproof == "") {

			document.getElementById('enter1').innerHTML += "<p>Enter Password</p>";

			return false;
		}
		return true;
	}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="STARTFROMHERE.jsp"%>
	<form action="LoginValidator" method="post"
		onsubmit="return display();" name="form">
		<p>
			Username: <input type="text" name="username" />
		</p>
		<p id='enter'></p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<p id='enter1'></p>
		<input type="submit" value="Enter Details" />
	</form>
</body>
</html>