/* 3) 4단계 
 * 성별을 입력받아서 처리할 것
 * 
 * 남성의 표준 몸무게 = 키(m) x 키(m) x 22; 
 * 여성의 표준 몸무게 = 키(m) x 키(m) x 21;
 * 
 * BMI = 계산하고
 * 비만도(%) = 실체중 / 표준체중 * 100 (표준체중 대비 실체중의 비율)
 * 
 * <출력결과>
 * 키 175.80cm인 남성의 표준 체중은 76.00kg입니다.
 * BMI는 25.45이고,
 * 비만도(%)는 1.4%입니다.
 */

import java.util.Scanner;

public class StandardWeight3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		String gender;
		double height, weight, temp;
		double stdWeight, fatRatio, bmi;
		
		System.out.print("성별(남/여)을 입력하시오 ");
		gender = keyin.next();
		
		System.out.print("키(cm)를 입력하시오 ");
		height = keyin.nextDouble();
		
		System.out.print("몸무게(kg)를 입력하시오 ");
		weight = keyin.nextDouble();

		// 표준체중 구하기
		temp = height / 100;
		
		if(gender.equals("남"))      // == 는 primitive 타입일 때 비교
			stdWeight = temp * temp * 22;
		else
			stdWeight = temp * temp * 21;
		
		// bmi 구하기
		bmi = weight / (temp * temp);
		
		// 비만율 구하기		
		fatRatio = weight / stdWeight * 100;
		
		
		System.out.printf("키 %.2fcm인 %s성의 표준 체중은 %.2fkg입니다.%n", height, gender, stdWeight);
		System.out.printf("BMI는 %.2f%n", bmi);
		System.out.printf("비만도(%%)는 %.2f%%입니다.%n", fatRatio);
		
		keyin.close();
	}

}
