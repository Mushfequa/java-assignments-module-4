package com;

import java.io.IOException;
import java.sql.SQLException;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
	if(email.equals("mushfeka@gmail.com") && password.equals("123456")) {
		
		//redirect home page
		
				//create Session
			HttpSession session = req.getSession();
			session.setAttribute("user", email);
			resp.sendRedirect("home.jsp");
			
	}else {
		
		// show error
		req.setAttribute("error", "Invalid User !!");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
}

}
