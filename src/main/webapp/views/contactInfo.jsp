<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b> ${SuccessMessage} </b>
	<b><a href="/">+Add more Contacts</a></b>
	<form:form action="saveContact" method="POST" modelAttribute="contact">
	<form:hidden path="contactId"/>
		<table>
			<tr>
			<td>Contact Name</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
			<td>Contact Mail</td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
			<td>Contact Number</td>
				<td><form:input path="phoneNo" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
			</tr>
			<a href="getAllData">View AllContacts</a>
		</table>
	</form:form>
</body>
</html>