package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static Connection getConnection() throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/message_passing";
        String USER = "root";
        String PASS = "";

try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection successful");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Connection error");

		}
		return DriverManager.getConnection(DB_URL,USER,PASS);



}
}