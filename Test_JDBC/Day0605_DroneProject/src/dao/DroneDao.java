package dao;

import java.util.List;

import vo.Drone;

public interface DroneDao {
	public int insertDrone(Drone drone);
	public Drone searchDrone(int serialNum); 
	public int removeDrone(int serialNum);
	public List<Drone> droneListForPrice(int minPrice, int maxPrice);
	public List<Drone> selectAll();
}
