package com;

import java.io.IOException;
import java.sql.SQLException;

import bean.User;
import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        String fName = req.getParameter("firstName");
        String lName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String gender = req.getParameter("gender");
        String password = req.getParameter("password");


        User user = new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setContact(contact);
        user.setGender(gender);
        user.setPassword(password);





        user.setPassword(password);

        UserDao dao = new UserDao();
        String error = null;
        String msg=null;
		try {
            int row = dao.insertUser(user);
			System.out.println("code executed : " + row);

            if (row > 0) {
				msg = "Message Inserted Successfully!";
            } else {
                error = "Failed to insert record.";
                req.setAttribute("error", error);
            }

        } catch (SQLException e) {
            error = "Error: " + e.getMessage();
        }
		     req.setAttribute("message", msg);

            req.setAttribute("error", error);
            req.getRequestDispatcher("register.jsp").forward(req, res);
        }
    }

