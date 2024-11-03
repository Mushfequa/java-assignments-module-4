package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SendMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String fromEmail = (String) session.getAttribute("email");
        String toEmail = request.getParameter("toEmail");
        String message = request.getParameter("message");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "")) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO messages (fromEmail, toEmail, message) VALUES (?, ?, ?)");
            ps.setString(1, fromEmail);
            ps.setString(2, toEmail);
            ps.setString(3, message);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewMessages.jsp");
    }
}
