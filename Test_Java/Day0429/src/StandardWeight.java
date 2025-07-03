/* 1) 1단계 
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

public class StandardWeight {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		double height = 175.8, temp;
		double stdWeight;
		
		System.out.println("키를 입력하시오 ");
		height = keyin.nextDouble();

		temp = height / 100;
		stdWeight = temp * temp * 22;
		
		System.out.printf("키 %.2fcm인 남성의 표준 체중은 %.2fkg입니다.%n", height, stdWeight);
		
		keyin.close();
	}

}
