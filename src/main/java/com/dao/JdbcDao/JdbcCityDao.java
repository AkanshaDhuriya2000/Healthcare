package com.dao.JdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Connection.JDBCBaseDAO;
import com.dao.CityDAO;
import com.model.City;

public class JdbcCityDao extends JDBCBaseDAO implements CityDAO{
	
	public JdbcCityDao(Connection connection) 
	{
		this.connection = connection;
	}

	@Override
	public ArrayList<City> getCityList() {
		ArrayList<City> citylist = new ArrayList<City>();
		try 
		{
			String sqlQuery ="SELECT id,stateid,name FROM apm_city";
			PreparedStatement ps= connection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				City city = new City();
				city.setId(rs.getInt("id"));
				city.setId(rs.getInt("stateid"));
				city.setName(rs.getString("name"));
				citylist.add(city);
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return citylist;
	}

}
