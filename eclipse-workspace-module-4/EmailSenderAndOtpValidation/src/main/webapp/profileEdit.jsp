<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<form id="profileForm">
  <input type="text" id="fname" name="fname" placeholder="First Name" value="${user.fname}" required>
  <input type="email" id="email" name="email" placeholder="Email" value="${user.email}" readonly>
  <button type="submit">Update Profile</button>
</form>

<script>
  $("#profileForm").submit(function(event) {
    event.preventDefault();
    $.ajax({
      url: "updateProfile",
      type: "POST",
      data: $(this).serialize(),
      success: function(response) {
        alert("Profile updated successfully.");
      }
    });
  });
</script>

</body>
</html>
