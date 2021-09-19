package com.ssn.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			String name=(String) session.getAttribute("uName");
			out.println("Hello, "+name+" admin welcome to dashboard.");
			RequestDispatcher reqDisp=request.getRequestDispatcher("links.html");
			reqDisp.include(request, response);
		}else {
			out.println("Please Login first");
			RequestDispatcher reqDispL=request.getRequestDispatcher("index.html");
			reqDispL.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
