package com.Controller;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.ConnectionProvider;
import com.Constants.Constants;
import com.dao.UserProfileDAO;
import com.dao.JdbcDao.JdbcUserProfileDAO;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {

		Connection connection = null;

		try {
			
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			connection = ConnectionProvider.getConnection();
			
			UserProfileDAO userProfileDAO = new JdbcUserProfileDAO(connection);
			boolean isUserExist = userProfileDAO.checkUserCreds(userid,password);
			
			if(!isUserExist)
			{
				PrintWriter out = response.getWriter();
				out.append("<b><center>Wrong userid or Password</center></b>");
				RequestDispatcher rd = request.getRequestDispatcher("pages/login.jsp");
				rd.include(request,response);
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute(Constants.islogin, true);//{key:value}
				PrintWriter out = response.getWriter();
				RequestDispatcher rd = request.getRequestDispatcher("pages/dashboard.jsp");
				rd.include(request,response);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
