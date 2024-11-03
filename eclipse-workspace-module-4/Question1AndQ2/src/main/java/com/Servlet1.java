package com;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ser1")
public class Servlet1 extends HttpServlet{

	private String message = "Hello World";

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

PrintWriter out =resp.getWriter();
out.write("<p> Servlet 1 is Calling</p>");

//get value from servlet config

	ServletConfig config = getServletConfig();
	String name = config.getServletName();
	String message = config.getInitParameter("message");
	
	out.write("<p>Servlet Name: "+name+"</p>");
	out.write(" message: "+message);

	

}
}