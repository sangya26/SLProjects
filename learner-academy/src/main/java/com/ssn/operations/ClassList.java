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


@WebServlet("/class")
public class ClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SUBJECT_INSERT_QUERY = "INSERT INTO LA_CLASS VALUES(?,?,?,?)";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("classId");
		String name=request.getParameter("className");
		String teacher=request.getParameter("classTeacher");
		String subject=request.getParameter("classSubject");
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
			statement.setString(3, teacher);
			statement.setString(4, subject);
			statement.executeUpdate();
			statement.close();
			out.println("<h1>Class details Inserted<h2>");
			out.println("<a href='class.html'>Back to class page</a></br><a href='/learner-academy/dashboard'>Back to dashboard</a>");
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
