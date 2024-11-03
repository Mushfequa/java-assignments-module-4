package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.MessageDao;
import DAO.UserDao;
import Model.Message;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/message")

public class MessageController {

	 void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String from = request.getParameter("from");
	        String to = request.getParameter("to");
	        String msg = request.getParameter("msg");

	        // Send the message
	        UserDao userDao = new UserDao();
	        MessageDao messageDao = new MessageDao();

	        try {
	            User fromUser = userDao.getUserByEmail(from);
	            if (fromUser != null) {
	                Message message = new Message();
	                message.setUid(fromUser.getUid());
	                message.setFrom(from);
	                message.setTo(to);
	                message.setMsg(msg);

	                int status = messageDao.sendMessage(message);
	                if (status > 0) {
	                    request.setAttribute("success", "Message sent successfully!");
	                } else {
	                    request.setAttribute("error", "Failed to send message.");
	                }
	            } else {
	                request.setAttribute("error", "Sender not found.");
	            }

	            request.getRequestDispatcher("message.jsp").forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String userEmail = request.getParameter("email");

	        // Get messages for the user
	        MessageDao messageDao = new MessageDao();
	        try {
	            List<Message> messages = messageDao.getMessagesByUser(userEmail);
	            request.setAttribute("messages", messages);
	            request.getRequestDispatcher("inbox.jsp").forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

