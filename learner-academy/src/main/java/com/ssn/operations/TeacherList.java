package com.ssn.operations;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;


@WebServlet("/teacher")
public class TeacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SUBJECT_INSERT_QUERY = "INSERT INTO LA_TEACHER VALUES(?,?)";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("teacherId");
		String name=request.getParameter("teacherName");
		
		try {
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			InputStream in=getServletContext().getResourceAsStream("WEB-INF/config.properties");
			Properties props=new Properties();
			props.load(in);
			
			DBConnection dbConnection=new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			
			PreparedStatement statement=dbConnection.getConnection().prepareStatement(SUBJECT_INSERT_QUERY);
			
			statement.setString(1, id);
			statement.setString(2, name);
			
			statement.executeUpdate();
			statement.close();
			out.println("<h1>Teacher's details inserted<h2>");
			out.println("<a href='teacher.html'>Back to teacher page</a></br><a href='/learner-academy/dashboard'>Back to dashboard</a>");
			out.println("</body></html>");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
