 package com.Controller;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Connection.ConnectionProvider;
import com.dao.CityDAO;
import com.dao.StateDAO;
import com.dao.UserProfileDAO;
import com.dao.JdbcDao.JdbcCityDao;
import com.dao.JdbcDao.JdbcStateDao;
import com.dao.JdbcDao.JdbcUserProfileDAO;
import com.model.City;
import com.model.State;
import com.model.UserProfile;

public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {

		try {
			Connection connection = ConnectionProvider.getConnection();
			UserProfileDAO userProfileDAO = new JdbcUserProfileDAO(connection);
			CityDAO cityDAO = new JdbcCityDao(connection);
			StateDAO stateDAO = new JdbcStateDao(connection);
			ArrayList<City> citylist = cityDAO.getCityList();
			ArrayList<State> statelist = stateDAO.getStateList();
            
			int userid = Integer.parseInt(request.getParameter("id"));

			UserProfile profile = userProfileDAO.findUserById(userid);
			request.setAttribute("statelist", statelist);
			request.setAttribute("citylist", citylist);
			request.setAttribute("profile", profile);
			RequestDispatcher rd = request.getRequestDispatcher("pages/userdetails.jsp");
			rd.include(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
