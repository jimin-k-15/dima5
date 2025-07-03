/*
 * Fitness 센터에서 관리하는 한 사람의 회원정보
 */

package fitness.vo;

public class FitnessVO {
	// id, 이름, 성별, 키, 몸무게,      표준체중, bmi, 결과 (계산된 데이터) 
	private int id;
	private String name;
	private String gender;
	private double height;
	private double weight;
	private double stdWeight;
	private double bmi;
	private String bmiResult;
	
	public FitnessVO() {}

	public FitnessVO(int id, String name, String gender, double height, double weight) {
		super();	// 상위 클래스를 생성하는 실행문. Object 클래스(모든 클래스의 최상위 클래스)를 생성
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		
		calcStdWeight();	// 표준체중
		calcBMI();			// bmi
		// 결과
	}

	// getter / setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		calcStdWeight();	// 표준체중
		calcBMI();			// bmi
		// 결과
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		
		calcBMI();			// bmi
	}
	
	// 일반 메소드
	
	// 표준체중 구하기
	public void calcStdWeight() {
		double temp = this.height / 100;	// m로 환산
		
		if(this.gender.equals("남")) {
			this.stdWeight = temp * temp * 22;
		} else {
			this.stdWeight = temp * temp * 21;
		}
	} 
	
	// BMI 구하기
	public void calcBMI() {
		double temp = this.height / 100;	// m로 환산
		
		this.bmi = weight / (temp * temp);
		calcBMIResult();
	} 
	
	// BMI 결과
	private void calcBMIResult() {
		if(this.bmi >= 35)			this.bmiResult = "고도 비만";
		else if(this.bmi >= 30)		this.bmiResult = "중도 비만";
		else if(this.bmi >= 25)		this.bmiResult = "경도 비만";
		else if(this.bmi >= 23)		this.bmiResult = "과체중";
		else if(this.bmi >= 18.5)	this.bmiResult = "정상";
		else						this.bmiResult = "저체중";
	}
	
	// 출력
	public String output() {
		String temp;
		temp = String.format("%3d %s %s %6.2fcm %6.2fkg 표준체중: %.2f  BMI: %.2f %s",
				id, name, gender, height, weight, stdWeight, bmi, bmiResult);
		return temp;
	}
	
	
	
	
	
	
}
