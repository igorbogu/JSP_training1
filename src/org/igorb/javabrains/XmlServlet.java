package org.igorb.javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if (username !="" && username !=null) {
			session.setAttribute("savedUserName", username );
			context.setAttribute("savedUserName", username );
		}
		out.println("Hello User!!"+ username);
		out.println("Sesion Hello User!!"+ (String) session.getAttribute("savedUserName"));
		out.println("Context Hello User!!"+ (String) context.getAttribute("savedUserName"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("userName");

		String fullname = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		//String location = request.getParameter("location");
		
		String[] location = request.getParameterValues("location");
		out.println("Hello from Post method!!"+ username + "! We know your full name" + fullname);
		out.println("You are a " + prof);
		out.println("You are from " + location.length + " places");
		for (int i=0;i<location.length; i++) {
			out.println(location[i]);
		}
	}
}
