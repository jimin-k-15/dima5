package baseball.vo;
import java.io.Serializable;

/**
 * 선수 정보 VO 클래스들의 상위 클래스
 */
public class Player implements Serializable {
	/**
	 * 선수 고유 번호
	 */
	private String id;
	/**
	 * 선수 이름
	 */
	private String name;
	/**
	 * 소속 팀 정보
	 */
	private String team;
	/**
	 * 연봉
	 */
	private int salary;
	/**
	 * WAR
	 */
	private double war;
	
	
	/**
	 * 기본 생성자
	 */
	public Player() {}

	/**
	 * Overloading 생성자: 0520 코드 확인
	 * @param id
	 * @param name
	 * @param team
	 * @param salary
	 * @param war
	 */
	public Player(String id, String name, String team, int salary, double war) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.salary = salary;
		this.war = war;
	}

	/**
	 * getter, setter
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getWar() {
		return war;
	}

	public void setWar(double war) {
		this.war = war;
	}

	@Override
	public String toString() {
		String temp = String.format("ID: %5s 이름: %5s 소속팀: %3s 연봉: %,7d WAR: %5.2f", id, name, team, salary, war); 
		return temp;
	}

	
	

	
}
	
	
	

