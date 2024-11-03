<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Home Page</title>
</head>
<body>
    <%
    String user = (String)session.getAttribute("student");

    if(user == null){
    	request.setAttribute("error","please login first");
    	request.getRequestDispatcher("logout").forward(request,response);
    }
 %>
    <h3>Welcome</h3>
<h2><%=user %></h2>
<a href ="logout" class ="btn btn-primary">Logout</a>

</body>
</html>