package com.Controller;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Connection.ConnectionProvider;
import com.dao.UserProfileDAO;
import com.dao.JdbcDao.JdbcUserProfileDAO;
import com.model.UserProfile;

public class UpdateUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {
		Connection connection = null;
		try {
		    connection = ConnectionProvider.getConnection();
			UserProfileDAO userProfileDAO = new JdbcUserProfileDAO(connection);
            
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			int stateid = Integer.parseInt(request.getParameter("stateid").trim());
			int cityid = Integer.parseInt(request.getParameter("cityid").trim());
			String dob = request.getParameter("dob");
			int id = Integer.parseInt(request.getParameter("id"));
            
			UserProfile user = new UserProfile();
			user.setId(id);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setAddress(address);
			user.setContact(contact);
			user.setEmail(email);
			user.setGender(gender);
			user.setStateid(stateid);
			user.setCityid(cityid);
			user.setDob(dob);
			
			int res = userProfileDAO.updateUser(user);
			
			if(res == 1) {
				ArrayList<UserProfile> list = userProfileDAO.getUserList();
				request.setAttribute("userlist", list);
				RequestDispatcher rd = request.getRequestDispatcher("pages/users.jsp");
				rd.include(request, response);
			}
			else {
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("fetchuser");
				rd.include(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
