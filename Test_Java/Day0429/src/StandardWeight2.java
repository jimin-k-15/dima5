/* 3) 3단계 
 * 성별을 입력받아서 처리할 것
 * 
 * 남성의 표준 몸무게 = 키(m) x 키(m) x 22; 
 * 여성의 표준 몸무게 = 키(m) x 키(m) x 21;
 * 
 * <출력결과>
 * 키 175.80cm인 남성의 표준 체중은 76.00kg입니다. --> printf()
 * 
 * 2) 2단계
 * 키보드로 데이터를 입력받아 처리하시오.
 * 
 */

import java.util.Scanner;

public class StandardWeight2 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		String gender;
		double height, temp;
		double stdWeight;
		
		System.out.println("성별(남/여)을 입력하시오 ");
		gender = keyin.next();
		
		System.out.println("키를 입력하시오 ");
		height = keyin.nextDouble();

		temp = height / 100;
		
		if(gender.equals("남"))      // == 는 primitive 타입일 때 비교
			stdWeight = temp * temp * 22;
		else
			stdWeight = temp * temp * 21;
		
		System.out.printf("키 %.2fcm인 %s성의 표준 체중은 %.2fkg입니다.%n", height, gender, stdWeight);
		
		keyin.close();
	}

}
