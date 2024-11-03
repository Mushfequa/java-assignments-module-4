<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Student Registration </title>

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
<div class="container d-flex justify-content-center min-vh-100 align-items-center ">
			<div class="col-5 card p-5">

<h3 class="d-flex justify-content-center"> Student Registration </h3>
	<form action="" name="insert" method="get">

		<table cellpadding= "7px" cellspacing = "7px">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" id="input_fname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" id="input_lname"></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="email" name="email" id="input_email"></td>
			</tr>

			<tr>
				<td>Contact</td>
				<td><input type="number" name="contact" id="input_contact"></td>
			</tr>

			
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female">Female</td>
			</tr>

				<td>Password</td>
				<td><input type="password" name="password" id="input_password"></td>
			</tr>
			
			<tr>
			<td colspan="2" align="center">
				<input type="submit"class="btn btn-success me-3" name="submit" value="INSERT">
			</td>
			</tr>

		</table>

	</form>
	</div>
	</div>

</body>
</html>