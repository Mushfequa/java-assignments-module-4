package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.DatabaseUtil;
import bean.User;

public class UserDao {

    public int insertUser(User user )throws SQLException{
    	Connection conn = DatabaseUtil.getConnection();
		String sql = "INSERT INTO users(firstname,lastname,email,contact,password) VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, user.getFirstName());
		stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getContact());
		stmt.setString(5, user.getGender());

		stmt.setString(6, user.getPassword());

		int Status = stmt.executeUpdate();
		return Status;

	}
}