/*
 * 정수를 입력받아 소수인지 여부를 출력하는 코드를 작성
 * 
 *   3은 소수입니다. 2
 *  12는 소수가 아닙니다! 
 */

import java.util.Scanner;

public class Exam08_1 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int value = 0;
		boolean isPrime = true;
		
		System.out.print("값을 입력: ");
		value = keyin.nextInt();
		
		for(int i=2; i<value; ++i) {
			if(value % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime)
			System.out.printf("%d는 소수입니다.%n", value);
		else
			System.out.printf("%d는 소수가 아닙니다.%n", value);
	}

}
