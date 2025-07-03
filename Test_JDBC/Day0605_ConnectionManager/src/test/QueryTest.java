package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionManager;

public class QueryTest {

	public static void main(String[] args) throws SQLException {
		// Connection을 얻어오기
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		
		String query = "select * from userinfo";
		
		pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();	
		
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String gender = rs.getString(3);
			System.out.println(id + "/" + name + "/" + gender);
		}
		System.out.println("End");
	}

}
