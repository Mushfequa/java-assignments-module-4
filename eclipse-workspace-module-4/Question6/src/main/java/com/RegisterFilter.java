package com;


import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/register")
public class RegisterFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest req,HttpServletResponse resp,FilterChain chain)
	{
		String fname =req.getParameter("fname");
		String lname =req.getParameter("lname");

		String email =req.getParameter("email");
		String contact =req.getParameter("contact");
		String gender =req.getParameter("gender");

		String password =req.getParameter("password");
		
try {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
			
			
			if(fname == null || fname.isBlank()) {
				
				req.setAttribute("fnameError", "First name required");
				dispatcher.forward(req, resp);
				return;
				
			}
			
			if(lname == null || lname.isBlank()) {
				
				req.setAttribute("lnameError", "Last name required");
				dispatcher.forward(req, resp);
				return;
				
			}
			
			
			if(email == null || email.isBlank()) {
				
				req.setAttribute("emailError", "Email is required");
				dispatcher.forward(req, resp);
				return;
			}
			
			  if(!AppUtil.isValidEmail(email)) {
	            	 
	            	
	            	 
	            	 req.setAttribute("emailError", " Invalid email address");
	 				dispatcher.forward(req, resp);
	 				return;
	 			
	             }
	             
	             
	             
	             if(contact == null || contact.isBlank()) {
	 				
	 				
	 				
	 				req.setAttribute("contactError", "Invalid contact number");
	 				dispatcher.forward(req, resp);
	 				return;
	 				
	             }
	             
	             if(gender == null || gender.isBlank()) {
	 				
	 				req.setAttribute("genderError", "gender  required");
	 				dispatcher.forward(req, resp);
	 				return;
	 				
	 			}
	 			
	             
	             if(password == null|| password.isBlank()) {
	            	 
	            	 
	            	 req.setAttribute("passwordError", "password is required");
	            	 dispatcher.forward(req, resp);
	            	 return;
	            	 
	             }
	             
	             if(!AppUtil.isValidPassword(password)) {
	            	
	            	 req.setAttribute("passwordError", "Invalid password ");
	            	 dispatcher.forward(req, resp);
	            	 return;
	            	 
	             }
	 				
	 	
			
				chain.doFilter(req, resp);

			
					}catch (Exception e) {
				e.printStackTrace();
				 
			
	
}
	}
	}
