import java.util.Scanner;    // ctrl + shift + o 

public class CalcBMI {
	public static void main(String[] args) {
		// 키, 몸무게, bmi 계산식 = 몸무게(kg) / 키(m)의 제곱 
		Scanner keyin = new Scanner(System.in);
		
		String name = "홍길동";   // 기본자료형처럼 선언하고 초기화 가능(String만!!!) 
		
//		System.in
		double height , temp;   // cm
		int weight;         // kg
		double bmi;
		
		// 키보드로부터 데이터 입력 
		System.out.print("키 입력: ");
		height = keyin.nextDouble();
		
		System.out.print("몸무게 입력: ");
		weight = keyin.nextInt();
		
		temp = height / 100; // 문장x, 계산식
		
		bmi = weight / (temp * temp);
		
		System.out.printf("키가 %.2fcm이고, 몸무게가 %dkg인 사람은 BMI가 %.2f입니다.", height, weight, bmi);
		
		keyin.close();
	}
}
