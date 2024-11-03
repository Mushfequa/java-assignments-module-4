<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editProfile" method="post">
    First Name: <input type="text" name="firstName" value="<%= session.getAttribute("firstName") %>" required><br>
    Last Name: <input type="text" name="lastName" value="<%= session.getAttribute("lastName") %>" required><br>
    Mobile: <input type="text" name="mobile" value="<%= session.getAttribute("mobile") %>" required><br>
    <input type="submit" value="Save Changes">
</form>

</body>
</html>