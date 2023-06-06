package com.Controller;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.ConnectionProvider;
import com.Constants.Constants;
import com.dao.UserProfileDAO;
import com.dao.JdbcDao.JdbcUserProfileDAO;
import com.model.UserProfile;

public class UserListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request,HttpServletResponse response) {
		try {
			HttpSession session=request.getSession();
			if(session.getAttribute(Constants.islogin)==null) {
				session.setAttribute(Constants.islogin, false);
			}
			boolean islogin=(boolean)session.getAttribute(Constants.islogin);
			if(!islogin) {
				response.sendRedirect("http://localhost:8080/Healthcare/");
			}else {
			
			Connection connection = ConnectionProvider.getConnection();
			UserProfileDAO userProfileDAO = new JdbcUserProfileDAO(connection);
			ArrayList<UserProfile> list= userProfileDAO.getUserList();
			request.setAttribute("userlist", list);
			RequestDispatcher rd = request.getRequestDispatcher("pages/users.jsp");
			rd.include(request, response);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}



