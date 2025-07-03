/*
 * 입력한 값이 3의 배수이면 누적에서 제외한다. 
 */
import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, total; 
		
		i = total = 0;
		
		while (true) {
			System.out.print("정수 입력 : ");
			i = scanner.nextInt();
			if(i < 0) break;
			
			if(i % 3 == 0) continue; 
			
			total += i;
			System.out.println("현재까지 누적합 : " + total);
				
			}
			System.out.println("종료합니다.");
			
		}
	}

