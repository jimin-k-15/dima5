/*
 * 정수를 입력받아 그 정수에 해당하는 구구단을 출력하시오. 
 * 	 3 x 1 = 3
 */

import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value = 0;
		
		System.out.print("값을 입력 : ");
		value = keyin.nextInt();
		
		for (int i = 1; i < 10; ++i) 
			System.out.printf("%d x %d = %d%n", value, i, (value * i));
		
	}

}
