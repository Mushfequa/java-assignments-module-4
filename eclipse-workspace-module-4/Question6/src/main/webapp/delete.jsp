<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*" %>
                        <%@ include file="dbConnection.jsp" %>
        
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    
</head>
<body>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    PreparedStatement ps = conn.prepareStatement("INSERT INTO deleted_data SELECT * FROM students WHERE id=?");
    ps.setInt(1, id);
    ps.executeUpdate();

    ps = conn.prepareStatement("DELETE FROM students WHERE id=?");
    ps.setInt(1, id);
    ps.executeUpdate();

    response.sendRedirect("list.jsp");
%>


</body>
</html>