package com;

import java.io.IOException;
import java.sql.SQLException;

import DAO.UserDao;
import Model.User;
import Util.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/UserServlet")

public class UserServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao(DatabaseUtil.getConnection());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        User user = new User();
        user.setFname(fname);
        user.setLname(lname);
        user.setEmail(email);
        user.setMobile(mobile);

        try {
            userDao.addUser(user);
            response.sendRedirect("userForm.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("message.jsp");
        }
    }
}
