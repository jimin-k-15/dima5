package ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import util.ConnectionManager;
import vo.User;

public class UserDAOImpl implements UserDAO {

	// 부모테이블에 데이터 저장
	@Override
	public int insert(User user) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO userinfo VALUES (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getGender());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 여기서 호출. User에 Tel과 Address가 있을 경우 호출
		if(user.getTel() != null && user.getAddress() != null) insertAddress(user);
		
		return 0;
	}
	
	// 언제 호출? 
	// 누가 호출? 
	private int insertAddress(User user) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO useraddr VALUES (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getTel());
			pstmt.setString(3, user.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public List<User> selectAll() {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		List<User> list = new ArrayList<User>();
		
		String query = "SELECT "
				+ "	i.id, i.name, i.gender, "
				+ "	a.tel, a.address "
				+ "FROM  "
				+ "	userinfo i RIGHT JOIN useraddr a "
				+ "USING (id)";
	
	try {
		pstmt = conn.prepareStatement(query); 	
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			list.add(new User(rs.getString(1), rs.getString(2), 
							  rs.getString(3), rs.getString(4), rs.getString(5))
			);
		}
	} catch (SQLException e ) {	
		e.printStackTrace();
	} finally {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return list;
	}
}
