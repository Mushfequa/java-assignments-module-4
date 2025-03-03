<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h2>Login</h2>
    
    <form id="loginForm">
        <input type="email" id="email" name="email" placeholder="Email" required>
        <input type="password" id="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>

    <p id="loginMessage" style="color: red;"></p>

    <script>
        $("#loginForm").submit(function(event) {
            event.preventDefault();
            $.ajax({
                url: "loginUser",  // Servlet URL for login
                type: "POST",
                data: $(this).serialize(),
                success: function(response) {
                    if (response.message === "Login successful") {
                        window.location.href = "profile.jsp";  // Redirect to profile page on success
                    } else {
                        $("#loginMessage").text(response.message);
                    }
                },
                error: function() {
                    $("#loginMessage").text("Error logging in. Please try again.");
                }
            });
        });
    </script>
</body>
</html>
y