package com.Connector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DbConnect {
	private static final String URL = Messages.getString("dbConnector.URL"); //$NON-NLS-1$
	private static final String Username = Messages.getString("dbConnector.USERNAME"); //$NON-NLS-1$
	private static final String Password =  Messages.getString("dbConnector.PASSWORD"); //$NON-NLS-1$
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static Connection conn = null;
	
	public DbConnect() {
			try {
				Class.forName(Driver).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public static Connection getConnection()
	{
	if (conn==null){
		try {	
			conn = DriverManager.getConnection(URL, Username, Password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}}
		return conn;
	}
	
}
