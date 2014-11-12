package dao;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public String isvalid() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			url = ConfigurationManager.getAppSetting("connection").trim();
			user = ConfigurationManager.getAppSetting("user").trim();
			password = ConfigurationManager.getAppSetting("pass").trim();
			
			
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("Database connected!");
			return "OK";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cannot connect the database!" + e.getLocalizedMessage());
			e.printStackTrace();
			return "ERROR: " + e.getMessage();
		}
	}
	
	public boolean execute_Ins_Upd_Del_Sql(Connection conn,String sql) {
		Statement pst = null;		
		try {
			pst = conn.createStatement();
			pst.execute(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("execute_Ins_Upd_Del_Sql--Error:" + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return true;
	}
	
	public ResultSet execute_Sel_Sql(Connection conn, String sql) {
		Statement pst = null;	
		ResultSet result = null;
		try {
			pst = conn.createStatement();
			result = pst.executeQuery(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("execute_Sel_Sql--Error:" + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return result;
	}

	
}
