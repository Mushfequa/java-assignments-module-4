package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DatabaseUtil;

import bean.User;

public class UserDao {



public int insertUser(User user) throws SQLException {

	Connection conn = DatabaseUtil.getConnection();
	String sql = "INSERT INTO users(fname,lname,email,contact,gender,password) VALUES(?,?,?,?,?,?)";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setString(1, user.getFirstName());
	stmt.setString(2, user.getEmail());
	stmt.setString(3, user.getContact());
	stmt.setString(4, user.getPassword());

	int Status = stmt.executeUpdate();
	return Status;

}

public User checkExistingUser(String email,String password)throws SQLException{
	User user = null;
	
	Connection conn=DatabaseUtil.getConnection();
    String sql ="SELECT*FROM users WHERE email =? and password =?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, email);
    stmt.setString(2, password);
    
    ResultSet rs = stmt.executeQuery();
    
    if(rs.next()) {
    	user =new User();
    	user.setId(rs.getInt("id"));
    	user.setFirstName(rs.getString("fname"));
    	user.setLastName(rs.getString("lname"));
    	user.setEmail(rs.getString("email"));
    	user.setContact(rs.getString("contact"));
    	user.setGender(rs.getString("gender"));

    	user.setPassword(rs.getString("password"));
    }
return user;
    }
}