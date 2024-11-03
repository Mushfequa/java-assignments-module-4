package com;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {

		String email=req.getParameter("email");
		String password=req.getParameter("password");
		if(email.equals("leswalamusfeka@gmail.com") && password.equals("123456")) {
		
		Random random =new Random();
		int otp = 100000 + random.nextInt(999999);
		
		EmailSender.sendEmail(email,"OTP Validation","your login OTP is:"+otp);
		
		ServletContext context = getServletContext();
		context.setAttribute("otp", otp+"");
		
		req.getRequestDispatcher("otp.jsp").forward(req, res);
	}else {
		req.getRequestDispatcher("register.jsp").forward(req, res);

	}
 }
}
