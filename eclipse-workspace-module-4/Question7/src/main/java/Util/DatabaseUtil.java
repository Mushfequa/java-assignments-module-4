package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static final String DB_URL="jdbc:mysql://localhost:3306/my_database";
	private static final String USER="root";
	private static final String PASS="";
	
	public static Connection getConnection() throws SQLException{
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