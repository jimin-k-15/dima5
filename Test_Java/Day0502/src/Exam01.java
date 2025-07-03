/*
 * [문제] seat라는 이름의 방 10개짜리 배열을 생성하시오.
 * (for문 말고 while문 사용)
 * . 
 * 0은 선택할 수 있는 방
 * 1은 이미 선택된 방이라서 선택할 수 없는 방
 * 
 * <선택할 수 있는 방> 
 * 0 0 0 0 0 0 0 0 0 0
 * 
 * 몇 번 방 선택하실래요? 1
 * 1 0 0 0 0 0 0 0 0 0
 * 
 * <선택할 수 있는 방> 
 * 1 0 0 0 0 0 0 0 0 0
 * 
 * 몇 번 방 선택하실래요? 5
 * 
 * <선택할 수 있는 방> 
 * 1 0 0 0 1 0 0 0 0 0
 * 
 * 몇 번 방 선택하실래요? 1 (이미 선택되었기 때문에 선택 불가)
 * 선택할 수 없습니다. 다시 선택하세요.
 * 
 * <선택할 수 있는 방> 
 * 1 0 0 0 1 0 0 0 0 0
 * 
 * 몇 번 방 선택하실래요? 15 (선택할 수 있는 방 범위를 벗어났으므로 종료)
 * 선택할 수 없습니다. 종료합니다.  
 */

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		// 1) 변수 선언 
		Scanner scanner = new Scanner(System.in);
		int[] seat = new int[10];
		int choice;
		int count = 0;     // 예약 완료된 방의 개수 : 10이 되면 종료
		
		while(true) {
			// 방 상태 출력
			System.out.println("<< 예약된 방 상태 >>");
			for(int i=0; i<seat.length; ++i) {
				System.out.print(seat[i] + "  ");
			}
			System.out.println("\n");
			
			// 예약
			System.out.print("** 몇 번 방? ");
			choice = scanner.nextInt();
			
			if(choice < 1 || choice > 10) {
				System.out.println("** 잘못된 입력으로 프로그램을 종료함");
				return;  
			}
			
			if(seat[choice-1] == 1) {
				System.out.println((choice) + "방은 이미 예약됨. 다시 선택하시오\n ");
				continue;
			}
			
			seat[choice-1] = 1; 
			count++;
			
			if(count >= 10) {
				System.out.println("** 방 전체 예약 완료됨. 프로그램 종료합니다.");
				return;
			}
			
		}
		
		/* 반복적으로 입력을 받기 
		 * - while(true)
		 * 	 10을 벗어난 값을 입력하면 종료
		 *   모든 방이 모두 1이 되면 종료
		 *   
		 *   - for문 이용해서 현재 방의 현재 상태 출력
		 *   - 입력 (선택을 함) 
		 *     10을 벗어난 값을 입력하면 종료
		 *   - 해당 방의 값을 확인 - 이미 선택된 상태 => 선택x => 다시 입력
		 * 						   - 선택할 수 있으면 선택
		 * 
		 */

	}
}
