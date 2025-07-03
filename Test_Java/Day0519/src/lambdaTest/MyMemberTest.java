package lambdaTest;

public class MyMemberTest {

	public static void main(String[] args) {
		MyMember m1 = new MyMember("홍길동", "남자", 175, 68);
		
		double h = 0;
		double w = 0;
		double m1StdWeight = (m1.getGender().equals("남자")
									? m1.calcStdWeight((a) -> ((a * a * 0.0001) * 22))
									: m1.calcStdWeight((a) -> ((a * a * 0.0001) * 21)));
		
		double m1BMI = m1.calcBMI( (x, y) -> x / (y*y*0.0001) );
		
		System.out.println(m1);
		System.out.println("표준 체중: " + m1StdWeight);
		System.out.println("BMI: " + m1BMI);
		
		System.out.println();
		
		MyMember m2 = new MyMember("홍길순", "여자", 175, 68);
		
		double m2StdWeight = (m2.getGender().equals("남자")
				? m2.calcStdWeight((a) -> ((a * a * 0.0001) * 22))
				: m2.calcStdWeight((a) -> ((a * a * 0.0001) * 21)));
		
		double m2BMI = m2.calcBMI( (x, y) -> x / (y*y*0.0001) );
		
		System.out.println(m2);
		System.out.println("표준 체중: " + m2StdWeight);
		System.out.println("BMI: " + m2BMI);
		
		
		
		
		
//		// 표준 체중 계산 공식: 키^2 * 22 (단위: kg)
//		Function<Double, Double> stdWeightFunc = (h) -> h * h * 0.0001 * 22;
//		
//		// BMI 계산 공식: 몸무게 / (키^2)
//		BiFunction<Double, Double, Double> bmiFunc = (h, w) -> w / (h * h * 0.0001);
//		
//		double stdWeight = m1.calcStdWeight(stdWeightFunc);
//		double bmi = m1.calcBMI(bmiFunc);
//		
//		System.out.printf("[%s] 키: %.1fcm, 몸무게: %.1fkg\n", m1.getName(), m1.getHeight(), m1.getWeight());
//		System.out.printf("표준 체중: %.2fkg\n", stdWeight);
//		System.out.printf("BMI: %.2f\n", bmi);
//		
//		
//		m1.calcBMI();			// 메소드 정의 부분이 () 안에 있어야 함
//		m1.calcStdWeight();

	}

}
