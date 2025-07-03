/*
 * [문제] 키보드로 정수를 입력받아 그 값이 소수인지 아닌지 판별하는 메서드를 작성하시오.
 * 
 * public static boolean isPrime(int number); <- method signiture
 * 소수로 판정되면 true, 아니면 false 반환
 */

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number;
		
		System.out.print("정수를 입력하시오: ");
		number = scanner.nextInt();
		
		if(isPrime(number)) {
			System.out.println(number+"는 소수입니다.");
		} else {
			System.out.println(number+"는 소수가 아닙니다.");
		}
	}
	
	public static boolean isPrime(int number) {
		for(int i=2; i<number; ++i) {
			if(number % i == 0) return false; 
		}
		return true;
	}

}
