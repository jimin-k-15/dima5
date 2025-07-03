/*
 * 정수를 입력받아 양수, 음수 판별하기 
 * 
 * 값 입력: -3
 * -3은 음수입니다. 
 * 
 */

import java.util.Scanner;

public class OperatorTest3 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value;
		String result;
		
		// 입력
		System.out.print("값 입력: ");
		value = keyin.nextInt();

		result = (value > 0) ? "양수" : (value < 0)	? "음수" : "영";
		
		System.out.printf("%d은 %s입니다.%n", value, result);
		
	}

}
