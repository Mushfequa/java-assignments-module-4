package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import Util.DatabaseUtil;
import bean.Student;

public class StudentDao {

    public int insertStudent(Student student) throws SQLException {
        Connection con = DatabaseUtil.getConnection();
                String sql = "INSERT INTO students (fname, lname, email, contact, gender, password) VALUES (?, ?, ?, ?, ?, ?)";

             PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getContact());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getPassword());

            return ps.executeUpdate();
        }
    

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection con = DatabaseUtil.getConnection();
        String sql = "SELECT * FROM students";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setEmail(rs.getString("email"));
                student.setContact(rs.getString("contact"));
                student.setGender(rs.getString("gender"));
                student.setPassword(rs.getString("password"));
                students.add(student);
            }
        
        return students;
    }

    public Student getStudentById(int id) throws SQLException {
    	User user=null;
    	Connection con = DatabaseUtil.getConnection();
        String sql = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setFname(rs.getString("fname"));
                    student.setLname(rs.getString("lname"));
                    student.setEmail(rs.getString("email"));
                    student.setContact(rs.getString("contact"));
                    student.setGender(rs.getString("gender"));
                    student.setPassword(rs.getString("password"));
                    return student;
                
            
        }
        return null;
    }
    
    public int updateStudent(Student student) throws SQLException {
        Connection con = DatabaseUtil.getConnection();
        String sql = "UPDATE students SET fname=?, lname=?, email=?, mobile=?, gender=?, password=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getContact());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getPassword());
            ps.setInt(7, student.getId());

            return ps.executeUpdate();
        }
    



    public int deleteStudent(int id) throws SQLException {
		int status = 0;
		Connection conn = DatabaseUtil.getConnection();
		String sql = "DELETE FROM students WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		status = stmt.executeUpdate();
		return status;

	}

}