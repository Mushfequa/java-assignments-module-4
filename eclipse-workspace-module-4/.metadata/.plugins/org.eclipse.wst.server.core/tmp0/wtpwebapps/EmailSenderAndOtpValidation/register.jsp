<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
  <form action="login" method="post">
  <input type="email"  name="email" placeholder="Email" required>
  <input type="password"  name="password" placeholder="Password" required>
  <input type="submit">
  </form>

<script>
  $("#registrationForm").submit(function(event) {
    event.preventDefault();
    $.ajax({
      url: "registerUser",
      type: "POST",
      data: $(this).serialize(),
      success: function(response) {
        alert(response.message);
        // Handle OTP process here
      },
      error: function() {
        alert("Error registering. Please try again.");
      }
    });
  });
</script>

</body>
</html>
