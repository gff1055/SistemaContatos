package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?autoReconnect=true&useSSL=true", "root", "souzag");
		}catch (SQLException | ClassNotFoundException e)
		{
			throw new RuntimeException(e);
//		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
		//	return null;
		}
	}

}
