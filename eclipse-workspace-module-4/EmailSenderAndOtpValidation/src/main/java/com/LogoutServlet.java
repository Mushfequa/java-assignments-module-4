package com;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//LogoutServlet.java
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     HttpSession session = request.getSession(false);
     if (session != null) {
         session.invalidate();
     }
     response.sendRedirect("login.jsp");
 }
}
