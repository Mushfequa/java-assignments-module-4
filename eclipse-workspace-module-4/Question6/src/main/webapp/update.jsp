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
    PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id=?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        if (request.getParameter("update") != null) {
            // Perform update
            ps = conn.prepareStatement("UPDATE students SET fname=?, lname=?, email=?, mobile=?, gender=?, password=? WHERE id=?");
            ps.setString(1, request.getParameter("fname"));
            ps.setString(2, request.getParameter("lname"));
            ps.setString(3, request.getParameter("email"));
            ps.setString(4, request.getParameter("mobile"));
            ps.setString(5, request.getParameter("gender"));
            ps.setString(6, request.getParameter("password"));
            ps.setInt(7, id);
            ps.executeUpdate();

            response.sendRedirect("list.jsp");
        }
%>
<form method="post">
    <!-- Form fields pre-filled with rs.getString("columnName") values for fname, lname, email, etc. -->
    <input type="submit" name="update" value="Update Student">
</form>
<%
    }
%>

</body>
</html>