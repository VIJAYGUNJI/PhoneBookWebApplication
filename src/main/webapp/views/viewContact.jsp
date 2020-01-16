<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <b><a href="/">+Add more Contacts</a></b>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" rules="all" style="background-color: cyan">
<thead>

<tr>
<td>S.No</td>
<td>Name</td>
<td>Email</td>
<td>Phoneno</td>
<td>Action</td>
</tr>
</thead>
<tbody>
<c:forEach items="${contactList}"  var="v" varStatus="status">
<tr>
<td>${status. index+1}</td>
<td>${v.contactName}</td>
<td>${v.contactEmail}</td>
<td>${v.phoneNo}</td>
<td>
	<a href="editContact?contactId=${v.contactId}">EDIT</a>
	<a href="deleteContact?contactId=${v.contactId}">DELET</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>