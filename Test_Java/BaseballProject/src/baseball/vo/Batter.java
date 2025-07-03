package baseball.vo;
/**
 * 타자 정보 VO
 */
public class Batter extends Player {
	/**
	 * 타율
	 */
	private double average;
	/**
	 * 타수
	 */
	private int atbat;
	/**
	 * 타점
	 */
	private int rbi;
	/**
	 * 득점
	 */
	private int score;
	
	/**
	 * 기본 생성자
	 */

	public Batter() {}

	/**
	 * 부모클래스의 멤버와, 자신의 멤버를 모두 파라미터로 전달받아서 
	 * 부모의 생성자 호출한 후, 자신의 멤버를 초기화
	 * 
	 * @param id
	 * @param name
	 * @param team
	 * @param salary
	 * @param war
	 * @param average
	 * @param atbat
	 * @param rbi
	 * @param score
	 */
	public Batter(String id, String name, String team, int salary, double war, double average, int atbat, int rbi, int score) {
		super(id, name, team, salary, war);
		this.average = average;
		this.atbat = atbat;
		this.rbi = rbi;
		this.score = score;
	}

	/**
	 * getter, setter
	 */
	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getAtbat() {
		return atbat;
	}

	public void setAtbat(int atbat) {
		this.atbat = atbat;
	}

	public int getRbi() {
		return rbi;
	}

	public void setRbi(int rbi) {
		this.rbi = rbi;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		String parent = super.toString();
		String temp = String.format(" 타율: %5.3f 타수: %4d 타점: %3d %4d", average, atbat, rbi, score);
		temp = parent + temp;
			
		return temp;
	}

	

	
	
}
