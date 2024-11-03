<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function validateForm() {
            var emailPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
            var passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@#$%&_]).{8,}$/;
            var email = document.forms["studentForm"]["email"].value;
            var password = document.forms["studentForm"]["password"].value;

            if (!emailPattern.test(email)) {
                alert("Invalid email format");
                return false;
            }
            if (!passwordPattern.test(password)) {
                alert("Password must contain uppercase, lowercase, number, and special character.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div
		class="container d-flex justify-content-center align-items-center min-vh-100">



		<div class="col-5 card p-5">
			<h3 class="text-center text-success mb-5">Registration Form</h3>

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
					aria-label="Close"></button>
			</div>
			<%
			}
			%>


			<form action="register" method="post">
				<div class="form-group mb-2">
					<label class="form-label">First Name</label> <input type="text"
						class="form-control" name="fname" id="fname" />
				</div>
				<div class="form-group mb-2">
					<label class="form-label">Last Name</label> <input type="text"
						class="form-control" name="lname" id="lname"/>
						
				</div>
				

				<div class="form-group mb-2">
					<label class="form-label">Email Address</label> <input type="text"
						class="form-control" name="email" id="email"/>
						
				</div>

				<div class="form-group mb-2">
					<label class="form-label">Contact Number</label> <input type="text"
						class="form-control" name="contact" id="contact"/>
										</div>

				<div class="form-group mb-2">
					<label class="form-label">Password</label> <input type="text"
						class="form-control" name="password" id="password"/>
						
				</div>

				<div>
					<input type="submit" class="btn btn-success me-3" id="submitButton"
						value="Submit"> <input type="reset"
						class="btn btn-primary  me-3" id="resetButton" value="Reset">
					<!-- <a href="ShowStudenServlet" class="btn btn-warning">View Users</a>  -->
				</div>

			</form>

		</div>



	</div>


</body>
</html>