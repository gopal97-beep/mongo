
<%@page import="user.book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME USER</h1>
<form method="post" action="user">


<table border=1px>
		<tr>
			<td>ID</td><td>NAME</td><td>AUTHOR</td>
		</tr>
		<c:forEach var="book1" items="${book}">
			<tr>
			 <td>${book1.id}</td>
				<td>${book1.name}</td>
				<td>${book1.author}</td>
				<td><input type="submit" name="button" value="view"/></td>
				<td><input type="submit" name="button" value="add"/></td>
				
			</tr>
			
		</c:forEach>
	</table>
	</form>


</body>
</html>