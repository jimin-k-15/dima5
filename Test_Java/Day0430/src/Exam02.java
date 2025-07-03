/*
 * [문제] 세 과목의 점수를 입력받아 수료 가능 여부 출력하기
 * - 출결, IT, 외국어 세 과목의 점수를 입력받습니다. 이때 각각의 점수 비중은 40%, 30%, 30%입니다.
 * - 총 점수가 70점 이상이면 "수료여부: 수료가능" 그렇지 않다면 "수료여부: 수료불가"를 출력하시오. 
 * 
 * <실행결과>
 * 출결 점수 : 80
 * IT 점수 : 60
 * 외국어 점수 : 45
 * 총점 : 63.5 수료여부 : 수료불가
 * 
 * 출결 점수 : 100
 * IT 점수 : 90
 * 외국어 점수 : 80
 * 총점 : 91.0 수료여부 : 수료가능
 * 
 */

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		
		System.out.print("출결 점수 : ");
		double attend = keyin.nextDouble();
		
		System.out.print("IT 점수 : ");
		double it = keyin.nextDouble();

		System.out.print("외국어 점수 : ");
		double lang = keyin.nextDouble();
		
		double total = attend * 0.4 + it * 0.3 + lang * 0.3;
		
		// 수료 여부 판단 (if 없이)
		boolean isPass = total >= 70;
		
		System.out.printf("총점 : %.1f 수료여부 : %s\n", total, isPass ? "수료가능" : "수료불가");
		
	}

}

