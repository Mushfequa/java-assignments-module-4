<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Data</title>
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

    
    </head>
<body>

<h2>Student Data</h2>

<!-- Set up the database connection -->
<sql:setDataSource var="dbSource" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/my_database"
                   user="root" password="" />

<!-- Execute SQL query to retrieve data from 'students' table -->
<sql:query dataSource="${dbSource}" var="studentData">
    SELECT * FROM students;
</sql:query>

<!-- Display the data in a table -->
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Gender</th>
            <th>Password</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach var="row" items="${studentData.rows}">
            <tr>
                <td>${row.id}</td>
                <td>${row.fname}</td>
                <td>${row.lname}</td>
                <td>${row.email}</td>
                <td>${row.contact}</td>
                <td>${row.gender}</td>
                <td>${row.password}</td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>