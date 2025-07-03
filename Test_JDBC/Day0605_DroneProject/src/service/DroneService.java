package service;

import java.util.List;

import dao.DroneDao;
import dao.DroneDaoImpl;
import vo.Drone;

public class DroneService {
	DroneDao dao = new DroneDaoImpl();
	
	/**
	 * 드론 등록을 위하여 dao로 데이터 넘김
	 * @param drone
	 * @return 1: 등록 성공, 0: 등록 실패
	 */
	
	public int insertDrone(Drone drone) {
		return dao.insertDrone(drone);
	}

	/**
	 * 드론의 고유번호(PK)를 이용하여 검색
	 * @param serialNum
	 * @return
	 */
	public Drone searchDrone(int serialNum) {
		return dao.searchDrone(serialNum);
	}

	/**
	 * 드론의 고유번호(PK)를 이용하여 삭제
	 * @param serialNum
	 * @return
	 */
	public int removeDrone(int serialNum) {
		return dao.removeDrone(serialNum);
	}

	/**
	 * 전체 데이터 조회
	 * @return
	 */
	public List<Drone> selectAll() {
		return dao.selectAll();
	}

	/**
	 * 특정 가격대의 드론 목록 조회
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Drone> droneListForPrice(int minPrice, int maxPrice) {
		return dao.droneListForPrice(minPrice, maxPrice);
	}
}