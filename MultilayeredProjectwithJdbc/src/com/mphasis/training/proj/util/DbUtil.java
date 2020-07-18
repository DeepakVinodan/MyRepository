package com.mphasis.training.proj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	static Connection con = null;
	private DbUtil() {
		
	}
	
	public static Connection openConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","deepak");  
            System.out.println("Connected");  
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
            System.out.println("DisConnected");  
			
		}catch(SQLException e) {
    		e.getStackTrace();
		}
		
	
	}

}
