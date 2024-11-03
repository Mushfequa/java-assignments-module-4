<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product  Form</title>
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
<div class="container  d-flex justify-content-center min-vh-100 align-items-center ">

			<div class="col-5 card p-5">
				<h3 class="text-center text-success mb-5">Product List</h3>
				
		 

<form action="ProductServlet" method="post">
				<div class="form group mb-2">
					<label class="form-label">Product Name</label> <input type="text"
						class="form-control" name="name" id="name" /> 
				</div>

				<div class="form group mb-2">
					<label class="form-label">Descreption</label> 
					<textarea name="description" id="description"rows="3" cols="58"></textarea> 
				</div>

				<div class="form group mb-2">
					<label class="form-label"> Price</label> <input type="text"
						class="form-control" name="price" id="price"/>
						
						</div>
				<div class="form group mb-2">
					<label class="form-label">Quantity</label> <input type="text"
						class="form-control" name="quentity" id="quentity"/>
								</div>
				<div>
					<input type="submit" class="btn btn-success me-3" id="submitButton"
						value="Submit"> <input type="reset"
						class="btn btn-primary me-3" id="resetButton" value="Reset">

				</div>

			</form>
		</div>

	</div>

</div>


</body>
</html>