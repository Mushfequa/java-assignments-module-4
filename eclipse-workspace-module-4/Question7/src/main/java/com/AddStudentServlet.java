package com;

import jakarta.servlet.FilterChain;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.AppUtil;
import bean.Student;

@WebServlet("/student")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password");
            PreparedStatement pst = con.prepareStatement("INSERT INTO students (fname, lname, email, mobile, gender, password) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, email);
            pst.setString(4, contact);
            pst.setString(5, gender);
            pst.setString(6, password);
            pst.executeUpdate();
            response.sendRedirect("ShowStudentServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}