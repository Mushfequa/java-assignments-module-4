package com;

import java.io.IOException;
import java.util.List;

import javax.mail.Message;

import DAO.MessageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//MessageServlet.java
@WebServlet("/messages")
public class MessageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
        List<Message> messages = MessageDAO.getMessagesForUser(email);
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("messages.jsp").forward(request, response);
    }
}
