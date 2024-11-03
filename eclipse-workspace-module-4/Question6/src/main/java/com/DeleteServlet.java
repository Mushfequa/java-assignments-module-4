package com;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;

@WebServlet("/delete")


public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		try {
			int row=dao.deleteStudent(id);
			if(row>0) {
				req.getRequestDispatcher("userlist").forward(req,resp);

			}
			
		}catch (SQLException e) {
			
		}
		
	}
}
