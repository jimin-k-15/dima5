// JDBC: Java DataBase Connectivity  
// MyBatis : Mapper라는 xml 파일로 연동
// JPA : Java Persistence (어느 DBMS라도 연동 가능 - SQL이 없음)

/*
 * 테이블 생성하는 코드
 */

package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) {
		// 1) 드라이버 준비
		String driver = "com.mysql.cj.jdbc.Driver";
		String url 	  = "jdbc:mysql://localhost/jdbc"; 
		String dbid   = "root";
		String dbpw   = "root";
		
		// 2) DB에 연결하고 사용할 객체를 선언
		Connection con = null;
		Statement stmt = null;
		String query = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, dbid, dbpw);		// connection 객체, connection 풀 
			query = "CREATE TABLE test1 (name varchar(10), age decimal(3))";
			
			stmt = con.createStatement();
			int result = stmt.executeUpdate(query); 
			System.out.println(result + "의 테이블 생성완료");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(stmt != null) stmt.close();
					if(con  != null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	}
}
