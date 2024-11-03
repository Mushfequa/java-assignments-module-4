package com;

import java.io.IOException;
import java.sql.SQLException;

import DAO.MessageDao;
import Model.Message;
import Util.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageServle")
public class MessageServlet extends HttpServlet {
    private MessageDao messageDao;

    @Override
    public void init() {
        messageDao = new MessageDao(DatabaseUtil.getConnection());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String msg = request.getParameter("msg");

        Message message = new Message();
        message.setUid(uid);
        message.setFrom(from);
        message.setTo(to);
        message.setMsg(msg);

        try {
            messageDao.addMessage(message);
            response.sendRedirect("messageSuccess.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}