package com.ssn.operations;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;


@WebServlet("/studentList")
public class MasterStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			InputStream in=getServletContext().getResourceAsStream("WEB-INF/config.properties");
			Properties props=new Properties();
			props.load(in);
			
			DBConnection dbConnection=new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			
			Statement statement=dbConnection.getConnection().createStatement();
			
			ResultSet rs=statement.executeQuery("SELECT * FROM LA_STUDENT ");
			out.println("<h1>Below is the STUDENTS details you requested :- </h1>");
			out.println("<h4>STUDENT ID"+"======"+"STUDENT NAME"+"======"+"CLASS ID</h4>");
			while(rs.next()) {
				out.println("=====>"+rs.getString(1)+"=========="+rs.getString(2)+"=========="+rs.getString(3)+"</br>");
				out.println();
			}
			out.println("<a href='/learner-academy/dashboard'>Back to dashboard</a>");
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
