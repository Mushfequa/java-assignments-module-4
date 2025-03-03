package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DatabaseConnection;

public class UserDAO {
    public static boolean validateUser(String email, String password) {
        boolean isValid = false;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);  // Ideally, passwords should be hashed
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isValid = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

	public static boolean updateProfile(String email, String fname, String lname) {
		// TODO Auto-generated method stub
		return false;
	}
}
