package com.ssn.validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uName=request.getParameter("USERNAME");
		String pwd=request.getParameter("PASSWORD");
		if(uName.equals("sangya") && pwd.equals("sangya")) {
			response.sendRedirect("/UserLogin/dashboard");
		}else {
			out.println("<h1>Sorry, the username and password error.</h1>");
			RequestDispatcher reqDis=request.getRequestDispatcher("login.html");
			reqDis.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
