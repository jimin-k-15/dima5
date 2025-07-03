/*
 * [문제]
 * 10개짜리 정수 배열을 선언하고 생성한 후
 * 1~100 사이의 정수를 발생시켜 저장하고 합계를 구하여 출력하시오.
 * 
 * <실행 예시>
 * 1 5 3 6 7 8 2 1 10 88 99 33
 * 합계 : xxx 
 */
public class Exam03 {

	public static void main(String[] args) {
		int[] iary = new int[10];
		int total = 0;
		
		// 초기화
		for (int i = 0; i < iary.length; i++) {
			iary[i] = (int)(Math.random() * 100 + 1); 
			total += iary[i];
		}
		
		// 출력
		for (int i = 0; i < iary.length; i++) {
			System.out.printf("%-4d", iary[i]);
		}
		System.out.println("\n합계: " + total);
	}
}
