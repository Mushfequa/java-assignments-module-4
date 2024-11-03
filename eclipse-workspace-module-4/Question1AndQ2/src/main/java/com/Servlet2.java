package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ser2")
public class Servlet2 extends HttpServlet {

	private String URL = "jdbc:mysql://localhost:3306/my_database";
	private String User = "root";
	private String Password = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.write("<p> Servlet 2 is Calling</p>");

		// get value from servlet config

		ServletConfig config = getServletConfig();
		String name = config.getServletName();
		String message = config.getInitParameter("message");

		out.write("<p>Servlet Name: " + name + "</p>");
		out.write(" message: " + message);

		ServletContext context = getServletContext();

		String db = context.getInitParameter("driver");
		String user = context.getInitParameter("user");
		String password = context.getInitParameter("password");
		out.write("<p>Driver Name: " + db + "</p>");
		out.write("<p>User Name: " + user + "</p>");
		out.write("<p>Password : " + password + "</p>");

	}

}
