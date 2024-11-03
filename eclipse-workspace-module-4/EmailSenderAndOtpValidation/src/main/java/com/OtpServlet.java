package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//OTPVerificationServlet.java
@WebServlet("/otp")

public class OtpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {

		String motp=req.getParameter("otp");
		
		ServletContext context = getServletContext();
		 String otp = (String)context.getAttribute("otp");
		 if(motp.equals(otp)) {
			 req.getRequestDispatcher("profileEdit.jsp").forward(req,res);
		 }else {
			 req.setAttribute("msg","Provide OTP mismatch");
			 req.getRequestDispatcher("otp.jsp").forward(req,res);

		
     

     }
 }
}