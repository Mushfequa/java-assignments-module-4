<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Registration</title>
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
<div class="container d-flex justify-content-center min-vh-100 align-items-center">

		<div class="col-5 card p-5">

        <h2>User Registration</h2>
    <form action="register" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="contact">Contact:</label>
        <input type="text" id="contact" name="contact" required><br><br>

        <label for="gender">Gender:</label>
        <input type="radio" id="male" name="gender" value="Male">Male
        <input type="radio" id="female" name="gender" value="Female">Female<br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" clas="btn btn-primary"id="submitButton" value="Register">     </form>
        <% String message = (String) request.getAttribute("message"); %>
    <%= (message != null) ? "<p style='color:red'>" + message + "</p>" : "" %>
    

    <% String error = (String) request.getAttribute("error"); %>
    <%= (error != null) ? "<p style='color:red'>" + error + "</p>" : "" %>
    </div>
    </div>
    
</body>
</html>