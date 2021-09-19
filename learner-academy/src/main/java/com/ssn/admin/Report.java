package com.ssn.admin;

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


@WebServlet("/report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("classId");
		try {
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			InputStream in=getServletContext().getResourceAsStream("WEB-INF/config.properties");
			Properties props=new Properties();
			props.load(in);
			
			DBConnection dbConnection=new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
			
			Statement statement=dbConnection.getConnection().createStatement();
			
			String query = "SELECT S.S_NAME,T.T_NAME,SB.SB_NAME FROM LA_CLASS C "
					+ "INNER JOIN LA_STUDENT S ON'"+id+"' =S.CLASS "
					+ "INNER JOIN LA_TEACHER T ON C.TEACHER=T.T_ID "
					+ "INNER JOIN LA_SUBJECT SB ON C.SUBJECT=SB.SB_ID";
			ResultSet rs=statement.executeQuery(query);
			out.println("<h4>STUDENT NAME"+"====="+"TEACHER NAME"+"====="+"SUBJECT NAME</h4>");
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
