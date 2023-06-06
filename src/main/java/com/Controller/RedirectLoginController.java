package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectLoginController extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
	RequestDispatcher rd=request.getRequestDispatcher("pages/login.jsp");
	rd.include(request, response);
	}
}
