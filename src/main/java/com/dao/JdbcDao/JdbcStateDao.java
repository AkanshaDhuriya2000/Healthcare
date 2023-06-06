package com.dao.JdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Connection.JDBCBaseDAO;
import com.dao.StateDAO;
import com.model.State;

public class JdbcStateDao extends JDBCBaseDAO implements StateDAO {
 
	public JdbcStateDao(Connection connection) 
	{
		this.connection = connection;
	}
	
	@Override
	public ArrayList<State> getStateList() {
		ArrayList<State> statelist = new ArrayList<State>();
		try 
		{
			String sqlQuery ="SELECT id,name from apm_state";
			PreparedStatement ps= connection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				State state = new State();
				state.setId(rs.getInt("id"));
				state.setName(rs.getString("name"));
				statelist.add(state);
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return statelist;
	}

}
