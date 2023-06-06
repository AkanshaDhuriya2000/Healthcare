package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Constants.Constants;

public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
		HttpSession session = request.getSession();
		if(session.getAttribute(Constants.islogin)==null) {
		session.setAttribute(Constants.islogin, false);
		}else {
			session.invalidate();
			response.sendRedirect(getServletInfo());d
		}
		RequestDispatcher rd = request.getRequestDispatcher("pages/login.jsp");
		rd.include(request, response);

	}
}