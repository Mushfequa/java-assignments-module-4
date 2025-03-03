<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*" %>
            <%@ page import="java.sql.*" %>
                <%@ include file="dbConnection.jsp" %>
        
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <h2>Register Student</h2>
    <form id="studentForm" action="StudentServlet" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label>First Name</label>
            <input type="text" name="fname" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Last Name</label>
            <input type="text" name="lname" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Mobile</label>
            <input type="text" name="mobile" class="form-control" maxlength="10" required>
        </div>
        <div class="form-group">
            <label>Gender</label>
            <input type ="radio" name="male">Male
            <input type ="radio" name="female">Female
                
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <%
    if (conn != null) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        // Render the table
    } else {
        out.println("Database connection not established.");
    }
%>
        
       
<%
    if (request.getParameter("submit") != null) {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        PreparedStatement ps = conn.prepareStatement("INSERT INTO students(fname, lname, email, mobile, gender, password) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, fname);
        ps.setString(2, lname);
        ps.setString(3, email);
        ps.setString(4, mobile);
        ps.setString(5, gender);
        ps.setString(6, password);
        ps.executeUpdate();

        response.sendRedirect("list.jsp");
    }
%>


<%
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM students");
%>
<table class="table table-bordered">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Gender</th>
        <th>Actions</th>
    </tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("fname") %></td>
        <td><%= rs.getString("lname") %></td>
        <td><%= rs.getString("email") %></td>
        <td><%= rs.getString("mobile") %></td>
        <td><%= rs.getString("gender") %></td>
        <td>
            <a href="edit.jsp?id=<%= rs.getInt("id") %>">Edit</a> |
            <a href="delete.jsp?id=<%= rs.getInt("id") %>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
    </form>
    </div>

<script>
    function validateForm() {
        var email = document.forms["studentForm"]["email"].value;
        var password = document.forms["studentForm"]["password"].value;
        
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=]).{6,}$/;
        
        if (!emailPattern.test(email)) {
            alert("Please enter a valid email address.");
            return false;
        }
        
        if (!passwordPattern.test(password)) {
            alert("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
