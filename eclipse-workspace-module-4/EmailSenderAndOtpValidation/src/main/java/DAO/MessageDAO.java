package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;

import Util.DatabaseConnection;

public class MessageDAO {

	 public static List<Message> getMessagesForUser(String email) {
	        List<Message> messages = new ArrayList<>();

	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String query = "SELECT from_email, to_email, content FROM messages WHERE to_email = ?";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                String fromEmail = rs.getString("from_email");
	                String toEmail = rs.getString("to_email");
	                String content = rs.getString("content");

	                // Create a Message object and add it to the list
	                messages.add(new Message(fromEmail, toEmail, content));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return messages;
	    }
	}
