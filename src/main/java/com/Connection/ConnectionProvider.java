package com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.Constants.Constants;

public class ConnectionProvider {

	public static Connection getConnection()
	{
		Connection connection=null;
	try {
		
		Class.forName(Constants.MySql_Driver);
		connection = DriverManager.getConnection(Constants.url,Constants.userId,Constants.password);
		
	} catch (Exception e) {
		e.getStackTrace();
	}
	return connection; 
	}
}
