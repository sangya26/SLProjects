package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection connection;
	
	public DBConnection(String dbUrl, String user, String password) throws ClassNotFoundException, SQLException {
		//load a driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//obtain connection
		connection = DriverManager.getConnection(dbUrl,user,password);
	}
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() throws SQLException{
		if(this.connection != null) {
			this.connection.close();
		}
	}
}
