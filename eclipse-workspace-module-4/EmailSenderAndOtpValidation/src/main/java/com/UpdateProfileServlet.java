package com;

import java.io.IOException;

import DAO.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//UpdateProfileServlet.java
@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
     String fname = request.getParameter("fname");
     String lname = request.getParameter("lname");
     String email = (String) request.getSession().getAttribute("email");

      UserDAO userdao=new UserDAO() ;
	boolean success = UserDAO.updateProfile(email, fname, lname);
     if (success) {
         response.getWriter().write("{\"message\":\"Profile updated successfully.\"}");
     } else {
         response.getWriter().write("{\"message\":\"Failed to update profile.\"}");
     }
 }
}
