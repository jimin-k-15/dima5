package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionManager;
import vo.Drone;

public class DroneDaoImpl implements DroneDao {

	@Override
	public int insertDrone(Drone drone) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0; 
				
		String query = "INSERT INTO drone (name, price, wingcount)" + " VALUES (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, drone.getName());
			pstmt.setInt(2, drone.getPrice());
			pstmt.setInt(3, drone.getWingCount());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * 
	 */
	@Override
	public Drone searchDrone(int serialNum) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		Drone drone = null; 
				
		String query = "SELECT * FROM drone WHERE serial_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, serialNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				drone = new Drone(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return drone; // null 또는 data가 반환됨 
	}

	/**
	 * 고유번호(PK)를 이용해 DB의 데이터를 삭제 
	 */
	@Override
	public int removeDrone(int serialNum) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0; 
				
		String query = "DELETE FROM drone WHERE serial_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, serialNum);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 특정 가격대의 드론 목록 조회
	 */
	@Override
	public List<Drone> droneListForPrice(int minPrice, int maxPrice) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		List<Drone> list = new ArrayList<Drone>();
				
		String query = "SELECT * FROM drone "
				+ "WHERE price BETWEEN ? AND ? "
				+ "ORDER BY name";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, minPrice);
			pstmt.setInt(2, maxPrice);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Drone drone = new Drone(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(drone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list; // null 또는 data가 반환됨 
	}

	/**
	 * 전체 데이터 조회
	 */
	@Override
	public List<Drone> selectAll() {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		List<Drone> list = new ArrayList<Drone>();
				
		String query = "SELECT * FROM drone ORDER BY name";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Drone drone = new Drone(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(drone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list; // null 또는 data가 반환됨 
		
	}

}
