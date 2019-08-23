<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.BasicDetailsBean,bean.BusDetails"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	function validate() {
		var name = document.forms["form"]["name"].value;


		document.getElementById('enter').innerHTML = "";

		document.getElementById('enter1').innerHTML = "";
		
		var numericExpression = /^[0-9]{12}$/;
		var idproofno = document.forms["form"]["idProofNo"].value;

		 if(name==null || name=="")
			{
				alert("enter the name");
				return false;
				}else if (idproofno == null || idproofno == "") {
					alert("enter the adhar num");
					return false;
				}
		else if (idproofno.match(numericExpression)) {
			return true;
		} else {
			alert("adhar number must be filled with 12 digit number only");
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
		BasicDetailsBean details = (BasicDetailsBean) session.getAttribute("details");
		BusDetails busDetails=(BusDetails)request.getAttribute("busDetails");
	%>
	<form action="ReservationServlet" name="form"
		onsubmit="return validate();">
		<table align="center" border="2">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
				<p id="enter">
			</tr>
			<tr>
				<td><input type="hidden" name="journey_id"
					value=<%=busDetails.getJourney_id()%> readonly></td>
			</tr>
			<tr>
			<td>Bus_Id:</td>
				<td><input type="text" name="bus_id"
					value=<%=request.getParameter("bus_id")%> readonly></td>
			</tr>
			<tr>
				<td>Source:</td>
				<td><input type="text" name="source"
					value=<%=details.getSource()%> readonly></td>
			</tr>
			<tr>
				<td>Destination:</td>
				<td><input type="text" name="destination"
					value=<%=details.getDestination()%> readonly></td>
			</tr>
			<tr>
				<td>No of Seats:</td>
				<td><input type="text" name="noOfSeats"
					value=<%=details.getNoOfSeats()%> readonly></td>
			</tr>
			<tr>
				
				<td><input type="hidden" name="stopNo1"
					value=<%=busDetails.getRouteno1()%> readonly></td>
			</tr>
			<tr>
				
				<td><input type="hidden" name="stopNo2"
					value=<%=busDetails.getRouteno2()%> readonly></td>
			</tr>
			<tr>
				<td>Fare(<%=details.getNoOfSeats()%>*<%=busDetails.getFare() %>)</td>
				<td><input type="text" name="fare" value=<%=details.getNoOfSeats()*busDetails.getFare()%> readonly></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="date" name="dateOfJourney"
					value=<%=details.getDateOfJourney()%> readonly></td>
			</tr>
			<tr>
				<td>Adhar No:</td>
				<td><input type="text" name="idProofNo"></td>
				<p id="enter1">
			</tr>
			<tr align="center">
				<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>