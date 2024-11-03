<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>OTP Verification</h1>

<form action ="otp"method="post">
<input type ="text"name="otp"placeholder="Enter OTP"/>
<input type="submit">
</form>
<span>${msg}</span>
</body>
</html>