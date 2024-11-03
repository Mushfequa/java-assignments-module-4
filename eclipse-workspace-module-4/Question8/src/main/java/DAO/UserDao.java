package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;
import Util.DatabaseUtil;

public class UserDao {
    public int insertUser(User user) throws SQLException {
        Connection con = DatabaseUtil.getConnection();
        String sql = "INSERT INTO user (fname, lname, email, mobile) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getMobile());

            int status= ps.executeUpdate();
            return status;
            
        }
    

    public User getUserByEmail(String email) throws SQLException {
    	User user =null;
        Connection con = DatabaseUtil.getConnection();
        String sql = "SELECT * FROM user WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(sql); 
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                    user  = new User();
                    user.setUid(rs.getInt("uid"));
                    user.setFname(rs.getString("fname"));
                    user.setLname(rs.getString("lname"));
                    user.setEmail(rs.getString("email"));
                    user.setMobile(rs.getString("mobile"));

                }
			return user;
            
        
    }


}
