/*
 * 정수를 입력받아 짝수, 홀수 판별하기 
 * 
 * 값 입력: 98
 * 98은 짝수입니다. 
 * 
 */

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value;
		String result;
		
		// 입력
		System.out.print("값 입력: ");
		value = keyin.nextInt();

		result = (value % 2 == 0) ? "짝수" : "홀수";
		
		System.out.printf("%d은 %s입니다.%n", value, result);
	}

}
