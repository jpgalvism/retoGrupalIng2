package dao;
import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.ResultSet;

import com.ConfigurationManager;


public class DataConection {
	
	private Connection con = null;
	private static DataConection datacon;
	
	
	private ResultSet rs = null;
	private String url;
	private String user;
	private String password;
    
	
	public java.sql.Connection getCon() {
		return con;
	}

	
	public static DataConection getDatacon() {
		if (datacon == null)
			datacon = new DataConection();
		return datacon;
	}

	private DataConection()
	{
		
	}
	
	public boolean isvalid() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			url = ConfigurationManager.getAppSetting("connection").trim();
			user = ConfigurationManager.getAppSetting("user").trim();
			password = ConfigurationManager.getAppSetting("pass").trim();
			
			
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("Database connected!");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cannot connect the database!" + e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
	}

	
}
