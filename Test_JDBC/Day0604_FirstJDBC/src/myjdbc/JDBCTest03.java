// JDBC: Java DataBase Connectivity  


// MyBatis : Mapper라는 xml 파일로 연동
// JPA : Java Persistence (어느 DBMS라도 연동 가능 - SQL이 없음)

/*
 * 테이블에 데이터를 넣는 코드 Statement로 x
 * PreparedStatement
 */

package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest03 {

	public static void main(String[] args) {
		// 1) 드라이버 준비
		String driver = "com.mysql.cj.jdbc.Driver";
		String url 	  = "jdbc:mysql://localhost/jdbc"; 
		String dbid   = "root";
		String dbpw   = "root";
		
		// 2) DB에 연결하고 사용할 객체를 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			Class.forName(driver);
			
			String name = "이순신";
			int age = 40;
			
			con = DriverManager.getConnection(url, dbid, dbpw);
			query = "INSERT INTO test1 VALUES (?, ?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, name);	// 1번째 Placeholder에 들어갈 데이터 세팅
			pstmt.setInt(2, age);		// 2번째 Placeholder에 들어갈 데이터 세팅 
			
			int result = pstmt.executeUpdate();		// 괄호 안에 아무것도 없어야 함 (아니면 에러) 
			System.out.println(result + "개의 데이터 삽입완료");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con  != null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	}
}
