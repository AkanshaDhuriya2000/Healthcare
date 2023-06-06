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
import com.dao.JdbcDao.JdbcCityDao;
import com.dao.JdbcDao.JdbcStateDao;
import com.model.City;
import com.model.State;

public class RegistrationFormController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest  request,HttpServletResponse response)
	{
		Connection connection = null;
		try 
		{   
			connection = ConnectionProvider.getConnection();
			CityDAO cityDAO = new JdbcCityDao(connection);
			ArrayList<City> citylist = cityDAO.getCityList();
			request.setAttribute("citylist", citylist);
			
			StateDAO stateDAO = new JdbcStateDao(connection);
			ArrayList<State> statelist = stateDAO.getStateList();
			request.setAttribute("statelist", statelist);
			
			RequestDispatcher rd = request.getRequestDispatcher("pages/registration.jsp");
			rd.include(request, response);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
