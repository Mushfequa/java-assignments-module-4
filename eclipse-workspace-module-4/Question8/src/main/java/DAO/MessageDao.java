package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Message;
import Util.DatabaseUtil;


public class MessageDao {

    public int sendMessage(Message message) throws SQLException {
        Connection con = DatabaseUtil.getConnection();

        String sql = "INSERT INTO messages (uid, `from`, `to`, msg) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, message.getUid());
            ps.setString(2, message.getFrom());
            ps.setString(3, message.getTo());
            ps.setString(4, message.getMsg());

            return ps.executeUpdate();
        }
    

    public List<Message> getMessagesByUser(String email) throws SQLException {
        List<Message> messages = new ArrayList<>();
        Connection con = DatabaseUtil.getConnection();
         String sql = "SELECT * FROM messages WHERE `to` = ?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery(sql); 
                while (rs.next()) {
                    Message message = new Message();
                    message.setId(rs.getInt("id"));
                    message.setUid(rs.getInt("uid"));
                    message.setFrom(rs.getString("from"));
                    message.setTo(rs.getString("to"));
                    message.setMsg(rs.getString("msg"));
                    messages.add(message);
                }
            
        
        return messages;
    }
}

