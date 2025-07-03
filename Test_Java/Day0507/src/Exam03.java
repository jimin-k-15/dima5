/*
 * [문제2] 2~100 사이의 모든 소수를 출력
 * 
 */

public class Exam03 {

	public static void main(String[] args) {
		int count = 0;
		
		for(int number=2; number <= 100; ++number) {
			if(isPrime(number)) {
				System.out.println(number + " ");
				++count;
			} 
		}
		System.out.println("\n2~100 사이의 소수의 개수: " + count + "개");
	}
	
	public static boolean isPrime(int number) {
		for(int i=2; i<number; ++i) {
			if(number % i == 0) return false; 
		}
		return true;
	}

}
