<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="registrationForm">
    First Name: <input type="text" name="firstName" required><br>
    Last Name: <input type="text" name="lastName" required><br>
    Mobile: <input type="text" name="mobile" required><br>
    Email: <input type="email" id="email" name="email" required><br>
    Password: <input type="password" name="password" required><br>
    <input type="button" value="Register" onclick="validateAndRegister()">
</form>

<div id="emailMessage"></div>

<script>
function validateAndRegister() {
    const email = document.getElementById("email").value;

    // Client-side validation for email uniqueness using AJAX
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "checkEmail", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            if (xhr.responseText === "exists") {
                document.getElementById("emailMessage").innerHTML = "Email already exists!";
            } else {
                document.getElementById("emailMessage").innerHTML = "Registering...";
                document.getElementById("registrationForm").submit();
            }
        }
    };
    xhr.send("email=" + email);
}
</script>

</body>
</html>