<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<h2> Admin login </h2>
id:<input type="text" name="id"/>
password:<input type="text" name="pwd"/>
<h4>${pas}</h4>
<input type="submit" value="admin" name="button"/><br>

<h2> user login </h2>
id:<input type="text" name="id1"/>
password:<input type="text" name="pwd1"/>
<h4>${pas}</h4>
<input type="submit" value="user" name="button"/>




</form>


</body>
</html>