// 클래스의 선언
package score;

public class Score {
	// 멤버변수 ==> private 
	private String id;		// private 멤버변수(=인스턴스변수)
	private String name;			// default 
	private double kor;
	private double eng;
	private double math;
	
	// setter / getter ==> 보일러플레이트 코드는 자동생성하는 것이 생산성 측면에서 좋다.   
	// Source -> Generate Getters and Setters 
	
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
	public double getKor() {
		return kor;
	}
	public void setKor(double kor) {
		this.kor = kor;
	}
	public double getEng() {
		return eng;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	
	// 접근지정자: 외부에서 데이터에 접근하는 범위를 결정
	
	
//	public void setId(String id) {
//		this.id = id;				// this가 붙어있지 않으면 지역변수 id
//	}
//	public String getId() {
//		return this.id;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getName() {
//		return this.name;
//	}
//	public void setKor(double kor) {
//		this.kor = kor;
//	}
//	public double getKor() {
//		return this.kor;
//	}
	
	
	
}
