/*
 * [문제] 키보드로 10개의 정수를 입력받는다. 정수의 합계를 구하여 출력
 * 
 * <실행>
 * 
 * 입력 1 : 4
 * 합계 : 4
 * 
 * 입력 2 : 1
 * 합계 : 5
 * 
 * 입력 3 : 2a
 * 잘못 입력함
 * 
 * 입력 3 : 2
 * 합계 : 7
 * ...
 * 입력 10 : 10
 * 합계 : 150
 * 프로그램 종료!
 * 
 */
package exceptTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int total = 0;
		int data = 0;
		
		int i = 1;		// 반복 제어변수
		
		while(i <= 10) {
			System.out.printf("입력 %d :", i);
			try {
				data = keyin.nextInt();
				
				total += data;
				System.out.printf("합계: %d\n\n", total);
				++i;
			} catch(InputMismatchException e) {
				keyin.nextLine();
				System.out.println("잘못 입력함");
				// --i;	<-- for문으로 할 경우와 while문으로 할 경우가 다름 
				continue;
			}
		}
		
		System.out.println("프로그램 종료!!!");
		
		
//		for (int i=1; i<=10;) {
//			System.out.print("입력" + i + " : ");
//			try {
//				data = Integer.parseInt(keyin.nextLine());
//				total += data;
//				System.out.println("합계 : " + total);
//				i++;
//			} catch (NumberFormatException e) {
//				System.out.println("잘못 입력함");
//			}
//		}
//
//		System.out.println("프로그램 종료!");
		
	}

}
