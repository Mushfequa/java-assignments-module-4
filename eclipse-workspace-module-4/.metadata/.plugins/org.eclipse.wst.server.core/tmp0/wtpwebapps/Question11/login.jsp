<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<div
		class="container d-flex justify-content-center min-vh-100 align-items-center">

		<div class="col-5 card p-5">
			<h3 class="text-center text-success mb-5">Login Form</h3>
			<%
				String message = (String) request.getAttribute("message");

				if (message != null) {
				%>
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<%=message%>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
				<%
				}
				%>
			

			<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
			%>
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<%=error%>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					arial-label="Close"></button>
			</div>
			<%
			}
			%>

			<form action="login" method="post">
				<div class="form-group mb-2">
					<label class="form-label">Email Address</label> <input type="text"
						class="form-control" name="email" id="email"
						onkeyup="validateForm();" /> <span class="tex-danger"
						id="emailErr"></span>
				</div>

				<div class="form-group mb-2">
					<label class="form-label">Password</label> <input type="text"
						class="form-control" name="password" id="password"
						onkeyup="validateForm();" /> <span class="tex-danger"
						id="passwordErr"></span>
				</div>

				<div class="mt-5">
					<input type="submit" class="btn btn-success me-3" id="submitButton"
						value="Login"> 

				</div>

			</form>
		</div>


	</div>

</body>
</html>