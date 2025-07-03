/*
 * [문제]
 * == up and down 프로그램 작성하기
 * 1~100 사이의 난수를 1개 발생시켜 5번 안에 맞추는 게임을 작성하시오.
 * 
 * <실행 예시>
 * 값을 입력: 50
 * UP! 
 * 
 * 값을 입력: 75
 * DOWN!
 * 
 * 값을 입력: 60
 * UP!
 * 
 * 값을 입력: 67
 * 오!! 천재시군요!
 */

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		int value = (int)Math.random() * 100 + 1;
		int input;
		Scanner keyin = new Scanner(System.in);
		
//		System.out.println("정답: " + value);
		
		for(int i=0; i < 5; ++i); {
			System.out.println("맞춰보시오! ");
			input = keyin.nextInt();
			
			if	   (value < input) System.out.println("Down!!");
			else if(value > input) System.out.println("Up!!");
			else   {
				System.out.println("오~ 맞췄군요!!!");
				System.exit(0); // 괄호 안에는 0 또는 1. 0은 일반적으로 프로그램 정상 종료를 의미하는 메서드 호출
			}
		}
		
		System.out.println("이것도 못 맞추냐?!!!");
		System.out.println("정답은: " + value);
		
		keyin.close();
	}
}
