/*
 * [문제-6] 시간 환산
 * 키보드로부터 정수 값에 해당하는 초 단위의 값을 입력 받아 시, 분, 초 단위로 환산하여 출력하는 프로그램을 작성하시오.
 * 
 * <실행 결과>
 * 시간을 초 단위로 입력하세요 : 2354
 * 2354초는 0시간 39분 14초입니다. 
 */

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		int time;
		int hour, min, sec, temp;
		
		System.out.print("시간을 초 단위로 입력하세요: ");
		
		time = keyin.nextInt();
		
		// 초
		sec = time % 60;
				
		// 중간값 temp에 저장
        temp = time / 60;  // 전체 초를 60으로 나눠서 '분'과 '시간' 계산에 사용

        // 분
        min = temp % 60;

        // 시
        hour = temp / 60;
		
		System.out.printf("%d초는 %d시간 %d분 %d초입니다.\n", time, hour, min, sec);

	}

}
