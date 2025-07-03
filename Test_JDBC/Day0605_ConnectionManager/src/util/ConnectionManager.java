/*
 * 싱글톤 패턴
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String url = "jdbc:mysql://localhost/jdbc";
	private static final String dbid = "root";
	private static final String dbpw = "root";
	
	private ConnectionManager() {}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public static Connection getConnection() {
	      Connection conn = null;
	      
	      try {
	         conn = DriverManager.getConnection(url, dbid, dbpw);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return conn;
	   }
}