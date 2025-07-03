/*
 * [문제] 반복적으로 정수를 입력받아 누적합계를 구하는 코드를 작성하시오.
 * 사용자가 음수를 입력하면 종료
 * 
 * <실행>
 * 값 : 3
 * 현재까지 누적합 : 3
 * 값 : 5
 * 현재까지 누적합 : 8
 * 값 : 10
 * 현재까지 누적합 : 18
 * 값 : -2
 * 현재까지 누적합 : xx
 * 종료합니다.
 * 
 */
import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, total; 
		
		i = total = 0;
		
		while (true) {
			System.out.print("정수 입력 : ");
			i = scanner.nextInt();
			if(i < 0) break;
			
			total += i;
			System.out.println("현재까지 누적합 : " + total);
				
			}
			System.out.println("종료합니다.");
			
		}
	}

